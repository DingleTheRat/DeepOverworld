// Made with Blockbench 5.0.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class grasin_bug extends EntityModel<Entity> {
	private final ModelPart bug;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	public grasin_bug(ModelPart root) {
		this.bug = root.getChild("bug");
		this.body = this.bug.getChild("body");
		this.leg1 = this.bug.getChild("leg1");
		this.leg2 = this.bug.getChild("leg2");
		this.leg3 = this.bug.getChild("leg3");
		this.leg4 = this.bug.getChild("leg4");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bug = modelPartData.addChild("bug", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData body = bug.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.25F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -2.25F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData leg1 = bug.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 1.0F, 2.5F));

		ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(1, 3).cuboid(-0.5F, 0.15F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData leg2 = bug.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 1.0F, 2.5F));

		ModelPartData cube_r2 = leg2.addChild("cube_r2", ModelPartBuilder.create().uv(1, 3).cuboid(-1.0F, 0.15F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData leg3 = bug.addChild("leg3", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 1.0F, -2.5F));

		ModelPartData cube_r3 = leg3.addChild("cube_r3", ModelPartBuilder.create().uv(1, 3).cuboid(-1.0F, 0.15F, 0.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData leg4 = bug.addChild("leg4", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 1.0F, -2.5F));

		ModelPartData cube_r4 = leg4.addChild("cube_r4", ModelPartBuilder.create().uv(1, 3).cuboid(-0.5F, 0.15F, 0.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bug.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}