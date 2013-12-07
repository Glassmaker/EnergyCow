package din.mod1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import din.mod1.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemEBucket extends ItemBucket {

	public ItemEBucket(int par1, int par2) {
		super(par1, par2);
		this.setCreativeTab(DinMod1.tabDin);
		this.setUnlocalizedName("ebucketUnlo");
		
		
		
		
	}
	@Override
	
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
	    }
	}
	
