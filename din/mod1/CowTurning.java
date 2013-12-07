package din.mod1;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * Broken
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;


public class CowTurning {

	

	   @ForgeSubscribe
	   public void onEntityUpdate(LivingUpdateEvent event) {
  
		  EntityCow ec = null;
		  /*
		   * When using AND ( &&) you must put in the brackets:
		   * if (swag && yolo) not if (swag) && (yolo)
		   */ 
	

		  if ((event.entityLiving.isPotionActive(Potion.fireResistance)) && (event.entityLiving.isBurning()))
		  
		  EntityPig
		 EntityPigZombie entitypigzombie = new EntityPigZombie(this.worldObj);
		 entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
		  this.worldObj.spawnEntityInWorld(entitypigzombie);
        this.setDead();
		        }
		    
		  
		  
		  {  
          

          
          {
		   
		   
		   
 }


	   }}