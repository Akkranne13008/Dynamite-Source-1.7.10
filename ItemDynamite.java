package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityDynamite;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemDynamite extends Item
{
    private static final String __OBFID = "CL_00000069";

    public ItemDynamite()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_776591, World p_776592, EntityPlayer p_776593)
    {
        if (!p_776593.capabilities.isCreativeMode)
        {
            --p_776591.stackSize;
        }

        p_776592.playSoundAtEntity(p_776593, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_776592.isClient)
        {
            p_776592.spawnEntityInWorld(new EntityDynamite(p_776592, p_776593));
        }

        return p_776591;





    }
}