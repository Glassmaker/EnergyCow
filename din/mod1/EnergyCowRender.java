package din.mod1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class EnergyCowRender extends RenderCow {
	 private static final ResourceLocation EcowTextures = new ResourceLocation("dinlearn", "textures/mob/energycow.png");

	    public EnergyCowRender(ModelBase par1ModelBase, float par2)
	    {
	        super(par1ModelBase, par2);
	    }

	    protected ResourceLocation getCowTextures(EntityCow par1EntityCow)
	    {
	        return EcowTextures;
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return this.getCowTextures((EntityCow)par1Entity);
	    }
	}
