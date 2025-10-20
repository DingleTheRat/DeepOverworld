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
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GrasinWorkbenchBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
	
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
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
		return this.pos;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("container.deepoverworld.grasin_workbench");
	}
	
	@Override
	public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new GrasinWorkbenchScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
	
	public void tick(World world1, BlockPos pos, BlockState state1) {
		if (hasRecipe()) {
			this.progress++;
			markDirty(world1, pos, state1);
			if (this.progress >= this.maxProgress) {
				craftItem();
				this.progress = 0;
				this.maxProgress = 72;
			}
		} else {
			this.progress = 0;
			this.maxProgress = 72;
		}
	}
	
	private void craftItem() {
		this.removeStack(INPUT_ITEM, 1);
		this.removeStack(INPUT_GOO, 1);
		
		setStack(OUTPUT_ITEM, new ItemStack(ModItems.GRASIN_B, this.getStack(OUTPUT_ITEM).getCount() + 1));
		setStack(OUTPUT_BYPRODUCT, new ItemStack(ModItems.GRASIN_C, this.getStack(OUTPUT_BYPRODUCT).getCount() + 1));
	}
	
	private boolean hasRecipe() {
		Item input2 = ModItems.GRASIN_GOO;
		ItemStack output1 = new ItemStack(ModItems.GRASIN_B);
		ItemStack output2 = new ItemStack(ModItems.GRASIN_C);
		
		return isInputItemValid() && this.getStack(INPUT_GOO).isOf(input2) &&
				canInsertIntoOutput(output1, OUTPUT_ITEM) && canInsertIntoOutput(output1.getCount(), OUTPUT_ITEM) &&
				canInsertIntoOutput(output2, OUTPUT_BYPRODUCT) && canInsertIntoOutput(output2.getCount(), OUTPUT_BYPRODUCT);
	}
	
	private boolean isInputItemValid() {
		return this.getStack(INPUT_ITEM).isOf(ModItems.GRASIN_A);
	}
	
	private boolean canInsertIntoOutput(ItemStack output, int slot) {
		return this.getStack(slot).isEmpty() || this.getStack(slot).getItem() == output.getItem();
	}
	
	private boolean canInsertIntoOutput(int count, int slot) {
		int maxCount = this.getStack(slot).isEmpty() ? 64 : this.getStack(slot).getMaxCount();
		int currentCount = this.getStack(slot).getCount();
		
		return maxCount >= currentCount + count;
	}
	
	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.writeNbt(nbt, registryLookup);
		Inventories.writeNbt(nbt, inventory, registryLookup);
		nbt.putInt("grasin_workbench.progress", progress);
		nbt.putInt("grasin_workbench.max_progress", maxProgress);
	}
	
	@Override
	protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		Inventories.readNbt(nbt, inventory, registryLookup);
		progress = nbt.getInt("grasin_workbench.progress");
		maxProgress = nbt.getInt("grasin_workbench.max_progress");
		super.readNbt(nbt, registryLookup);
	}
	
	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}
	
	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
		return createNbt(registryLookup);
	}
}
