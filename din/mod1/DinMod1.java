package din.mod1;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;









import java.util.ArrayList;

import net.minecraft.client.model.ModelCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import din.mod1.proxy.CommonProxy;
import din.mod1.lib.Reference;
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)


public class DinMod1 {
	
	
	
	@Instance(Reference.MOD_ID)
	
	
	public static DinMod1 instance;
	
	public static Item energyBullDrink;
	
	public static Item steroids;
	
	
	public static Potion flightPotion;
	
	@SidedProxy(clientSide = Reference.ClientP, serverSide = Reference.ServerP)
	
	public static CommonProxy proxy;
	
 

    @EventHandler
    
    public void preInit(FMLPreInitializationEvent event) {

   
    /*This crap is actually needed. Don't delete it!Seriously...It does stuff */
    	Potion[] potionTypes = null;

    	for (Field f : Potion.class.getDeclaredFields()) {
    	f.setAccessible(true);
    	try {
    	if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
    	Field modfield = Field.class.getDeclaredField("modifiers");
    	modfield.setAccessible(true);
    	modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

    	potionTypes = (Potion[])f.get(null);
    	final Potion[] newPotionTypes = new Potion[256];
    	System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
    	f.set(null, newPotionTypes);
    	}
    	}
    	catch (Exception e) {
    	System.err.println("That's weird. Must be a bug.Bugger.HA!GET IT?NO? Whatever, report it!");
    	System.err.println(e); 	}
    	}

    	MinecraftForge.EVENT_BUS.register(new ModEventHooks());
    /*Don't touch this stuff above K?!!*/
    
    
 
    	
    } 	
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
  
    	energyBullDrink = (new ItemRedBullDrink(3500));
    	
    	LanguageRegistry.addName(energyBullDrink, "§6Energy drink");
    	
    	steroids = (new ItemSteroids(3501));
    	
    	LanguageRegistry.addName(steroids, "§1Steroids");
    	

    	
    	
    	flightPotion = (new PotionFlight(32, false, 0)).setIconIndex(0, 0).setPotionName("Flight");
    	
    	GameRegistry.addRecipe(new ItemStack(steroids), new Object[]{
            "ZCZ",
            "CXC",
            "ZCZ",
            'X', Item.appleGold, 'C', Item.sugar, 'Z', Item.magmaCream
           
     });
    	EntityRegistry.registerModEntity(EntityEnergyCow.class, "EnergyCow", 0, this, 32, 5, true);
        EntityRegistry.addSpawn(EntityEnergyCow.class, 10, 2, 3, EnumCreatureType.creature, BiomeGenBase.desert);
    }
   
    @EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
    	
    }
   
}

