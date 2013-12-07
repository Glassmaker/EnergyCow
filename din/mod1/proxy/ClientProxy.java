package din.mod1.proxy;

import net.minecraft.client.model.ModelCow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import din.mod1.EnergyCowRender;
import din.mod1.EntityEnergyCow;
import din.mod1.EntityMutantCow;

public class ClientProxy extends CommonProxy {
	
	
	@Override
	public void registerRenderer(){

		EnergyCowRender ecr = new EnergyCowRender(new ModelCow(), 0.5F);
		RenderingRegistry.registerEntityRenderingHandler(EntityEnergyCow.class, ecr);
		MutantCowRender mcr = new MutantCowRender(new ModelCow(), 0.5F);
		RenderingRegistry.registerEntityRenderingHandler(EntityMutantCow.class, mcr);
		

	}

}	    
