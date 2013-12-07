package din.mod1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.potion.Potion;

public class PotionStuff {

	
	public static void preInit (){
		
		
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
	}
	
	
	public static void init (){
    	DinMod1.flightPotion = (new PotionFlight(32, false, 0)).setIconIndex(0, 0).setPotionName("Flight");	
	
	}
}
