package din.mod1;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLS extends Item {
	public ItemLS(int par1) {
		super(par1);
	this.setCreativeTab(CreativeTabs.tabCombat);
	}

	 public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
     	float var4 = 1.0F;

     	world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
     	if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.consumeInventoryItem(DinMod1.LSummoner.itemID);
     	return true;
     	}
     
	
}
