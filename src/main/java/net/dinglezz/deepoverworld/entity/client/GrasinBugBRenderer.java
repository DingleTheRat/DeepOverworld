package net.dinglezz.deepoverworld.entity.client;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.entity.custom.GrasinBugBEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GrasinBugBRenderer extends MobEntityRenderer<GrasinBugBEntity, GrasinBugModel<GrasinBugBEntity>> {
	public GrasinBugBRenderer(EntityRendererFactory.Context context) {
		super(context, new GrasinBugModel<>(context.getPart(GrasinBugModel.GRASIN_BUG)), 0.1f);
	}
	
	@Override
	public Identifier getTexture(GrasinBugBEntity entity) {
		return Identifier.of(DeepOverworld.MOD_ID, "textures/entity/grasin_bug_type_b.png");
	}
}

























