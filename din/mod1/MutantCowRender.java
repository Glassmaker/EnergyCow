package din.mod1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class MutantCowRender extends RenderCow {
	 private static final ResourceLocation McowTextures = new ResourceLocation("energycow", "textures/mob/mutantcow.png");


		public MutantCowRender(ModelBase par1ModelBase, float par3) {
			super(par1ModelBase, par3);
		}
		
	    public ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return McowTextures;
	    }
	    
	    public ResourceLocation getCowTextures(Entity par1Entity)
	    {
	        return McowTextures;
	    }
	    
	    public int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	    {
	        return -1;
	    }

}