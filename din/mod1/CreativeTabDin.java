package din.mod1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabDin extends CreativeTabs {

    public CreativeTabDin(int par1, String par2Str) {
        
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        
        return DinMod1.steroids.itemID;
    }

}
