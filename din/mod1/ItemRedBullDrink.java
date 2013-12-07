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
        super(id, 4, 2.0F, false);
        setHasSubtypes(true);
        setMaxDamage(0);
        this.setAlwaysEdible();
        this.setCreativeTab(DinMod1.tabDin);
        this.setUnlocalizedName("itemBullDrinkCode");
    }

    protected void onFoodEaten (ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            int duration = 0;
            PotionEffect potion;

            potion = player.getActivePotionEffect(DinMod1.flightPotion);
            if (potion != null)
                duration = potion.duration;
            player.addPotionEffect(new PotionEffect(DinMod1.flightPotion.id, duration + 300 * 20, 0));
    
        }
    }
	@Override
	
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
	    }
	}
	

