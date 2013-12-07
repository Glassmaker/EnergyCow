package din.mod1;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MobClass {
	
	static int startEntityId = 300;
	
public static void init (){
	
	
	
	EntityRegistry.registerModEntity(EntityEnergyCow.class, "Energy Cow", 2, DinMod1.instance, 80, 5, true);
 	registerEntityEgg(EntityEnergyCow.class, 0x3E3123, 0x800000);	
 	DinMod1.proxy.registerRenderer();
	EntityRegistry.registerModEntity(EntityMutantCow.class, "Mutant Cow", 3, DinMod1.instance, 32, 5, true);
	EntityRegistry.addSpawn(EntityMutantCow.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
	registerEntityEgg(EntityMutantCow.class, 0x3E3123, 0x800000);	
}


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

}
