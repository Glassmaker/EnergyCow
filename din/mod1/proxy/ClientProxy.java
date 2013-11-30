package din.mod1.proxy;
import net.minecraft.client.model.ModelCow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import din.mod1.EnergyCowRender;
import din.mod1.EntityEnergyCow;
import din.mod1.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {
    @Override
	public void registerRenderer () {
		
	RenderingRegistry.registerEntityRenderingHandler(EntityEnergyCow.class, new EnergyCowRender(new ModelCow() , 0F));	
		
		
	}
	



}	    
