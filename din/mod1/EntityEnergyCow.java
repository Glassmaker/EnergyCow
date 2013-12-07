package din.mod1;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityEnergyCow extends EntityAnimal {
	
	public final int fluidId = 3503;

	public EntityEnergyCow(World par1World)
	    {
	        super(par1World);
	        this.setSize(0.9F, 1.3F);
	        this.getNavigator().setAvoidsWater(true);
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
	        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
	        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, DinMod1.steroids.itemID, false));
	        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
	        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	        this.tasks.addTask(7, new EntityAILookIdle(this));
	    }

	    /**
	     * Returns true if the newer Entity AI code should be run
	     */
	    public boolean isAIEnabled()
	    {
	        return true;
	    }

	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(7.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.20000000298023224D);
	    }

	    /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return "mob.cow.say";
	    }

	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "mob.cow.hurt";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "mob.cow.hurt";
	    }

	    /**
	     * Plays step sound at given x, y, z for the entity
	     */
	    protected void playStepSound(int par1, int par2, int par3, int par4)
	    {
	        this.playSound("mob.cow.step", 0.15F, 1.0F);
	    }

	    /**
	     * Returns the volume for the sounds this mob makes.
	     */
	    protected float getSoundVolume()
	    {
	        return 0.4F;
	    }

	    /**
	     * Returns the item ID for the item the mob drops on death.
	     */
	    protected int getDropItemId()
	    {
	        return Item.leather.itemID;
	    }

	 

	    /**
	     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	     */
	    public boolean interact(EntityPlayer par1EntityPlayer)
	    {
	        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

	        if (itemstack != null && itemstack.itemID == Item.bucketEmpty.itemID && !par1EntityPlayer.capabilities.isCreativeMode)
	        {
	            this.setDead();
	            par1EntityPlayer.setFire(10);
	            if (itemstack.stackSize-- == 1)
	            {
	                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(DinMod1.instance.eBucket));
	                this.setDead();
	                par1EntityPlayer.setFire(10);
	            }
	            else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DinMod1.instance.eBucket)))
	            {
	                par1EntityPlayer.dropPlayerItem(new ItemStack(DinMod1.instance.eBucket.itemID, 1, 0));
	                this.setDead();
	                par1EntityPlayer.setFire(10);
	            }
	          
	            return true;
	        }
	        else
	        {
	            return super.interact(par1EntityPlayer);
	        }
	    }
	    public boolean isBreedingItem(ItemStack par1ItemStack)
	    {
	        return par1ItemStack != null && par1ItemStack.itemID == DinMod1.steroids.itemID;
	    }

	    
	    
	    
	    /**
	     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
	     */
	    public EntityEnergyCow spawnBabyAnimal(EntityAgeable par1EntityAgeable)
	    {
	        return new EntityEnergyCow(this.worldObj);
	    }

	    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	    {
	        return this.spawnBabyAnimal(par1EntityAgeable);
	    }
	}
