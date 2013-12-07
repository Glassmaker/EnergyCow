package din.mod1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockEnergyFluid extends BlockFluidClassic {

        @SideOnly(Side.CLIENT)
        protected Icon stillIcon;
        @SideOnly(Side.CLIENT)
        protected Icon flowingIcon;
        
        public BlockEnergyFluid(int id, Fluid fluid, Material material) {
                super(id, fluid, material);
                setUnlocalizedName("eFluid");
                setCreativeTab(DinMod1.tabDin);
        }
        
        @Override
        public Icon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void registerIcons(IconRegister register) {
                stillIcon = register.registerIcon("dinlearn:eFluidStill");
                flowingIcon = register.registerIcon("dinlearn:eFluidMove");
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
        
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
       
        
        
       
       
        
        
        
        
        
        
        
}