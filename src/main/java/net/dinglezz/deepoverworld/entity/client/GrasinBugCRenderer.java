package net.dinglezz.deepoverworld.entity.client;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.entity.custom.GrasinBugCEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GrasinBugCRenderer extends MobEntityRenderer<GrasinBugCEntity, GrasinBugRenderState, GrasinBugModel> {
	public GrasinBugCRenderer(EntityRendererFactory.Context context) {
		super(context, new GrasinBugModel(context.getPart(GrasinBugModel.GRASIN_BUG)), 0.1f);
	}
	
	@Override
	public GrasinBugRenderState createRenderState() {
		return new GrasinBugRenderState();
	}
	
	@Override
	public Identifier getTexture(GrasinBugRenderState entity) {
		return Identifier.of(DeepOverworld.MOD_ID, "textures/entity/grasin_bug_type_v.png");
	}
}