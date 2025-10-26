package net.dinglezz.deepoverworld.entity.client;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.entity.custom.GrasinBugBEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GrasinBugBRenderer extends MobEntityRenderer<GrasinBugBEntity, GrasinBugRenderState, GrasinBugModel> {
	public GrasinBugBRenderer(EntityRendererFactory.Context context) {
		super(context, new GrasinBugModel(context.getPart(GrasinBugModel.GRASIN_BUG)), 0.1f);
	}
	
	@Override
	public GrasinBugRenderState createRenderState() {
		return new GrasinBugRenderState();
	}
	
	@Override
	public Identifier getTexture(GrasinBugRenderState entity) {
		return Identifier.of(DeepOverworld.MOD_ID, "textures/entity/grasin_bug_type_b.png");
	}
}