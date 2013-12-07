/****
	Din's mod #1 ( published )
	Energy cow!
	To do:
	Clean the code up
	Extra cows and better breeding
	Good spawning method
	Clean the code up again
	Lightning rod texture and model
	Better textures!
	Energy drink recipe
	And moooooore!
***/
package din.mod1;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import din.mod1.proxy.CommonProxy;
import din.mod1.lib.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true)

/* Din's reminder Thing #1
 * Public static Item : Per class
 * Public Item : Everywhere ( per instance )
 * 
 * Referencing NOT static ones : MainClass.instance.firhlga
 * */
public class DinMod1 {
	
	static int startEntityId = 300;
	
	@Instance(Reference.MOD_ID)
	
	public static DinMod1 instance;
	
	public static Item energyBullDrink;
	
	public static Item steroids;
	
	public static Item LSummoner;
	
	public static Potion flightPotion;
	
	public final int fluidId = 3503;
	public Item eBucket = new ItemEBucket(3505, fluidId);
	public Fluid eFluid;
	
	public Block eFluidBlock;
	
	@SidedProxy(clientSide = Reference.ClientP, serverSide = Reference.ServerP)
	
	public static CommonProxy proxy;
	

    @EventHandler
    
    public void preInit(FMLPreInitializationEvent event) {
    
    	PotionStuff.init();
    

    	MinecraftForge.EVENT_BUS.register(new ModEventHooks());
    	MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    
    } 	
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	 
    	energyBullDrink = (new ItemRedBullDrink(3500));
    	
    	LanguageRegistry.addName(energyBullDrink, "§6Energy drink");
    	
    	steroids = (new ItemSteroids(3501));
    	
    	LanguageRegistry.addName(steroids, "§1Steroids");

    	LSummoner = (new ItemLS(3502));
    	
    	LanguageRegistry.addName(LSummoner, "§4Lightning summoner");

//Don't touch the mob//
    	EntityRegistry.registerModEntity(EntityEnergyCow.class, "Energy Cow", 2, this, 80, 5, true);
     	LanguageRegistry.instance().addStringLocalization("entity.EnergyCow.Energy Cow.name", "Energy Cow");
     	 registerEntityEgg(EntityEnergyCow.class, 0x3E3123, 0x800000);																					
    	proxy.registerRenderer();
    	flightPotion = (new PotionFlight(32, false, 0)).setIconIndex(0, 0).setPotionName("Flight");
    	
    	GameRegistry.addRecipe(new ItemStack(steroids), new Object[]{
            "ZCZ",
            "CXC",
            "ZCZ",
            'X', Item.appleGold, 'C', Item.sugar, 'Z', Item.magmaCream});
    	//You can touch now
    	
    	eFluid = new Fluid("efluid").setBlockID(fluidId);

    	FluidRegistry.registerFluid(eFluid);
    	
    	eFluidBlock = new BlockEnergyFluid(fluidId, eFluid, Material.water);
    	GameRegistry.registerBlock(eFluidBlock, "EnergyFluid");
    	eFluidBlock.setUnlocalizedName(eFluidBlock.getUnlocalizedName());
    	LanguageRegistry.addName(eFluidBlock, "Energy fluid");
  
    
    	GameRegistry.registerItem(eBucket, "Energy Liquid bucket");
    	FluidContainerRegistry.registerFluidContainer(new FluidStack(eFluid, 1000), new ItemStack(eBucket), new ItemStack(Item.bucketEmpty));
    	LanguageRegistry.addName(eBucket, "§2Energy Liquid Bucket");
    	BucketHandler.INSTANCE.buckets.put(eFluidBlock, eBucket);
    }
    //Don't touch
    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
    {
    int id = getUniqueEntityId();
    EntityList.IDtoClassMapping.put(id, entity);
    EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
    
    public static int getUniqueEntityId() 
    {
    do 
    {
    startEntityId++;
    } 
    while (EntityList.getStringFromID(startEntityId) != null);

    return startEntityId;
    }
   //You can touch under 

   
    @EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
    	
    }
    
  
}
