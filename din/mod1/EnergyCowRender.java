package din.mod1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class EnergyCowRender extends RenderCow {
	 private static final ResourceLocation EcowTextures = new ResourceLocation("energycow", "textures/mob/energycow.png");


		public EnergyCowRender(ModelBase par1ModelBase, float par3) {
			super(par1ModelBase, par3);
		}
		
	    public ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return EcowTextures;
	    }
	    
	    public ResourceLocation getCowTextures(Entity par1Entity)
	    {
	        return EcowTextures;
	    }
	    
	    public int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	    {
	        return -1;
	    }

}