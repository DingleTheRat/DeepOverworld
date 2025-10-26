package net.dinglezz.deepoverworld.block.entity.custom;

import net.dinglezz.deepoverworld.block.entity.ImplementedInventory;
import net.dinglezz.deepoverworld.block.entity.ModBlockEntities;
import net.dinglezz.deepoverworld.item.ModItems;
import net.dinglezz.deepoverworld.screen.custom.GrasinWorkbenchScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GrasinWorkbenchBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
	
	private static final Recipe[] RECIPES = {
			new Recipe(ModItems.GRASIN_A,
					new ItemStack(ModItems.GRASIN_B, 1),
					new ItemStack(ModItems.GRASIN_C, 2))
	};
	
	private static final int INPUT_ITEM = 0;
	private static final int INPUT_GOO = 1;
	private static final int OUTPUT_ITEM = 2;
	private static final int OUTPUT_BYPRODUCT = 3;
	
	protected final PropertyDelegate propertyDelegate;
	private int progress = 0;
	private int maxProgress = 72;
	
	public GrasinWorkbenchBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.GRASIN_WORKBENCH_BE, pos, state);
		this.propertyDelegate = new PropertyDelegate() {
			@Override
			public int get(int index) {
				return switch (index) {
					case 0 -> GrasinWorkbenchBlockEntity.this.progress;
					case 1 -> GrasinWorkbenchBlockEntity.this.maxProgress;
					default -> 0;
				};
			}
			
			@Override
			public void set(int index, int value) {
				switch (index) {
					case 0: GrasinWorkbenchBlockEntity.this.progress = value;
					case 1: GrasinWorkbenchBlockEntity.this.maxProgress = value;
				}
			}
			
			@Override
			public int size() {
				return 2;
			}
		};
		
	}
	
	@Override
	public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
		return this.pos;
	}
	
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("container.deepoverworld.grasin_workbench");
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new GrasinWorkbenchScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
	
	@Override
	public void onBlockReplaced(BlockPos pos, BlockState oldState) {
		ItemScatterer.spawn(world, pos, (this));
		super.onBlockReplaced(pos, oldState);
	}
	
	@Override
	protected void writeData(WriteView view) {
		super.writeData(view);
		Inventories.writeData(view, inventory);
		view.putInt("grasin_workbench.progress", progress);
		view.putInt("grasin_workbench.max_progress", maxProgress);
	}
	
	@Override
	protected void readData(ReadView view) {
		super.readData(view);
		Inventories.readData(view, inventory);
		progress = view.getInt("grasin_workbench.progress", 0);
		maxProgress = view.getInt("grasin_workbench.max_progress", 72);
	}
	
	public void tick(World world, BlockPos pos, BlockState state) {
		if(hasRecipe()) {
			increaseCraftingProgress();
			markDirty(world, pos, state);
			
			if(hasCraftingFinished()) {
				craftItem();
				resetProgress();
			}
		} else {
			resetProgress();
		}
	}
	
	private void resetProgress() {
		this.progress = 0;
		this.maxProgress = 72;
	}
	
	private void craftItem() {
		ItemStack outputItem = getOutputItem();
		ItemStack outputByproduct = getOutputByproduct();
		this.removeStack(INPUT_ITEM, 1);
		this.removeStack(INPUT_GOO, 1);
		
		this.setStack(OUTPUT_ITEM, new ItemStack(outputItem.getItem(),
				this.getStack(OUTPUT_ITEM).getCount() + outputItem.getCount()));
		this.setStack(OUTPUT_BYPRODUCT, new ItemStack(outputByproduct.getItem(),
				this.getStack(OUTPUT_BYPRODUCT).getCount() + outputByproduct.getCount()));
		System.out.println("Crafted: " + outputItem + " using " + getStack(INPUT_ITEM) + " + " + getStack(INPUT_GOO));
	}
	
	private boolean hasCraftingFinished() {
		return this.progress >= this.maxProgress;
	}
	
	private void increaseCraftingProgress() {
		this.progress++;
	}
	
	private boolean hasRecipe() {
		if (inventory.get(INPUT_GOO).isOf(ModItems.GRASIN_GOO) && isInRecipeList()) {
			ItemStack outputItem = getOutputItem();
			ItemStack outputByproduct = getOutputByproduct();
			return canInsertAmountIntoOutputSlot(outputItem.getCount(), OUTPUT_ITEM) &&
					canInsertItemIntoOutputSlot(outputItem, OUTPUT_ITEM) &&
					canInsertAmountIntoOutputSlot(outputByproduct.getCount(), OUTPUT_BYPRODUCT) &&
					canInsertItemIntoOutputSlot(outputByproduct, OUTPUT_BYPRODUCT);
		} else return false;
	}
	
	private ItemStack getOutputItem() {
		for (Recipe recipe : RECIPES) {
			if (inventory.getFirst().isOf(recipe.inputItem)) {
				return recipe.outputItem;
			}
		}
		return ItemStack.EMPTY;
	}
	
	private ItemStack getOutputByproduct() {
		for (Recipe recipe : RECIPES) {
			if (inventory.getFirst().isOf(recipe.inputItem)) {
				return recipe.outputByproduct;
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean isInRecipeList() {
		for (Recipe recipe : RECIPES) {
			if (inventory.getFirst().isOf(recipe.inputItem)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean canInsertItemIntoOutputSlot(ItemStack output, int slot) {
		return this.getStack(slot).isEmpty() || this.getStack(slot).getItem() == output.getItem();
	}
	
	private boolean canInsertAmountIntoOutputSlot(int count, int slot) {
		int maxCount = this.getStack(slot).isEmpty() ? 64 : this.getStack(slot).getMaxCount();
		int currentCount = this.getStack(slot).getCount();
		
		return maxCount >= currentCount + count;
	}
	
	@Nullable
	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}
	
	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
		return createNbt(registryLookup);
	}
	@Override
	public int size() { return inventory.size(); }
	
	@Override
	public boolean isEmpty() {
		for (ItemStack stack : inventory) if (!stack.isEmpty()) return false;
		return true;
	}
	
	@Override
	public ItemStack getStack(int slot) { return inventory.get(slot); }
	
	@Override
	public ItemStack removeStack(int slot, int amount) {
		return Inventories.splitStack(inventory, slot, amount);
	}
	
	@Override
	public ItemStack removeStack(int slot) {
		return Inventories.removeStack(inventory, slot);
	}
	
	@Override
	public void setStack(int slot, ItemStack stack) {
		inventory.set(slot, stack);
		markDirty();
	}
	
	@Override
	public int[] getAvailableSlots(Direction side) {
		if (side == Direction.UP) {
			return new int[] {0};
		} else if (side == Direction.DOWN) {
			return new int[] {2, 3};
		} else {
			return new int[] {1};
		}
	}
	
	@Override
	public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
		if (dir == Direction.UP && slot == 0) {
			return isValidMainIngredient(stack);
		} else if (dir != Direction.UP && slot == 1) {
			return isValidGoo(stack);
		}
		return false;
	}
	
	@Override
	public boolean canExtract(int slot, ItemStack stack, Direction dir) {
		if (dir == Direction.DOWN) {
			return slot == 2 || slot == 3;
		}
		return false;
	}
	
	private boolean isValidMainIngredient(ItemStack stack) {
		return stack.isOf(ModItems.GRASIN_A);
	}
	
	private boolean isValidGoo(ItemStack stack) {
		return stack.isOf(ModItems.GRASIN_GOO);
	}
	
	record Recipe(Item inputItem, ItemStack outputItem, ItemStack outputByproduct) {}
}
