package din.mod1;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import din.mod1.lib.Reference;

public class ItemRedBullDrink extends ItemFood{

	public ItemRedBullDrink(int id) 
	{
		super(id,0,0f, false);
	this.setCreativeTab(CreativeTabs.tabFood);
	this.setMaxStackSize(1);
	this.setUnlocalizedName("itemBullDrinkCode");
	}
	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	        par3EntityPlayer.addPotionEffect(new PotionEffect(DinMod1.flightPotion.getId(), 6000, 2));
	        return new ItemStack(Item.bucketEmpty);
	    }
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
	@Override
	
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
	    }
	}
	

