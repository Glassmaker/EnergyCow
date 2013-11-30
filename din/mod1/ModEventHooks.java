/*
 * Thanks to pillbox from IRC
 * #TinkersConstruct
 * For helping with the code
 * My code didn't turn of the flymode after the potion
 * expired. Thanks dude <3
 */



package din.mod1;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
public class ModEventHooks {

@ForgeSubscribe
public void onEntityUpdate(LivingUpdateEvent event) {
    EntityLivingBase el = event.entityLiving;
    EntityPlayer ep = null;

    if (el instanceof EntityPlayer) {
            ep = (EntityPlayer)el;
    } else {
          
            return;
    }

    if (event.entityLiving.isPotionActive(DinMod1.flightPotion)) {
            ep.capabilities.allowFlying = true;
    } else if (ep.capabilities.allowFlying && !ep.capabilities.isCreativeMode) {
            ep.capabilities.allowFlying = false;
            ep.capabilities.isFlying = false;
            ep.fallDistance = 0.0F;
    }
}
}