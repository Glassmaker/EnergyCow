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

public class DinMod1 {
	@Instance(Reference.MOD_ID)
	public static DinMod1 instance;
	@SidedProxy(clientSide = Reference.ClientP, serverSide = Reference.ServerP)
	public static CommonProxy proxy;
		

	
		public static Item energyBullDrink;
		
		public static Item steroids;
	
		public static Item LSummoner;
	
		public static Potion flightPotion;
	
		public final int fluidId = 3503;
		public Item eBucket = new ItemEBucket(3505, fluidId);
		public Fluid eFluid;
	
		public Block eFluidBlock;
	
		
	

			@EventHandler
			public void preInit(FMLPreInitializationEvent event) {
    
					PotionStuff.preInit();
    

					MinecraftForge.EVENT_BUS.register(new ModEventHooks());
					MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    
    } 	
    
    
			@EventHandler
			public void init(FMLInitializationEvent event) {
					MobClass.init();
					PotionStuff.init();
					ItemClass.init();

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


   
    @EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
    	
    }
    
  
}
