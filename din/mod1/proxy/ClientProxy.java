package din.mod1.proxy;

import net.minecraft.client.model.ModelCow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import din.mod1.EnergyCowRender;
import din.mod1.EntityEnergyCow;

public class ClientProxy extends CommonProxy {
	
	
	@Override
	public void registerRenderer(){

		EnergyCowRender boobs = new EnergyCowRender(new ModelCow(), 0.5F);
		RenderingRegistry.registerEntityRenderingHandler(EntityEnergyCow.class, boobs);

	}

}	    
