package net.dinglezz.deepoverworld.entity.client;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class GrasinBugModel extends EntityModel<GrasinBugRenderState> {
	public static final EntityModelLayer GRASIN_BUG = new EntityModelLayer(Identifier.of(DeepOverworld.MOD_ID,
			"grasin_bug"), "main");
	private final ModelPart bug;
	
	public GrasinBugModel(ModelPart root) {
		super(root);
		this.bug = root.getChild("bug");
	}
	
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bug = modelPartData.addChild("bug", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		ModelPartData body = bug.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.25F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -2.25F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 1.0F, 0.0F));
		ModelPartData leg1 = bug.addChild("leg1", ModelPartBuilder.create(), ModelTransform.rotation(2.0F, 1.0F, 2.5F));
		ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(1, 3).cuboid(-0.5F, 0.15F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
		ModelPartData leg2 = bug.addChild("leg2", ModelPartBuilder.create(), ModelTransform.rotation(-2.5F, 1.0F, 2.5F));
		ModelPartData cube_r2 = leg2.addChild("cube_r2", ModelPartBuilder.create().uv(1, 3).cuboid(-1.0F, 0.15F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
		ModelPartData leg3 = bug.addChild("leg3", ModelPartBuilder.create(), ModelTransform.rotation(-2.5F, 1.0F, -2.5F));
		ModelPartData cube_r3 = leg3.addChild("cube_r3", ModelPartBuilder.create().uv(1, 3).cuboid(-1.0F, 0.15F, 0.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
		ModelPartData leg4 = bug.addChild("leg4", ModelPartBuilder.create(), ModelTransform.rotation(2.0F, 1.0F, -2.5F));
		ModelPartData cube_r4 = leg4.addChild("cube_r4", ModelPartBuilder.create().uv(1, 3).cuboid(-0.5F, 0.15F, 0.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	
	@Override
	public void setAngles(GrasinBugRenderState state) {
		super.setAngles(state);
	}
}
