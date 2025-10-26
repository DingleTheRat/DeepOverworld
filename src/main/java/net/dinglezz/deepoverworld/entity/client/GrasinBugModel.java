package net.dinglezz.deepoverworld.entity.client;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class GrasinBugModel extends EntityModel<GrasinBugRenderState> {
	public static final EntityModelLayer GRASIN_BUG = new EntityModelLayer(Identifier.of(DeepOverworld.MOD_ID,
			"grasin_bug"), "main");
	
	public GrasinBugModel(ModelPart root) {
		super(root);
	}
	
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		return TexturedModelData.of(modelData, 16, 16);
	}
}
