package din.mod1;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemClass {

	public static void init (){ 
		DinMod1.energyBullDrink = (new ItemRedBullDrink(3500));
    	
		LanguageRegistry.addName(DinMod1.energyBullDrink, "§6Energy drink");

		DinMod1.steroids = (new ItemSteroids(3501));

		LanguageRegistry.addName(DinMod1.steroids, "§1Steroids");

		DinMod1.LSummoner = (new ItemLS(3502));

		LanguageRegistry.addName(DinMod1.LSummoner, "§4Lightning summoner");
		
		
		
	}
	
}
