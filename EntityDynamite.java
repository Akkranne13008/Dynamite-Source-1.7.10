package net.minecraft.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDynamite extends EntityThrowable


{
	public EntityLivingBase shootingEntity;
	public int field_92057_e = 1;
    private static final String __OBFID = "CL_00001722";

    public EntityDynamite(World p_i1779_1_)

    {
        super(p_i1779_1_);
    }

    public EntityDynamite(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
    }

    public EntityDynamite(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    protected float func_70182_d()
    {
        return 0.6F;
    }

    protected float func_70183_g()
    {
        return -20.0F;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isClient && this.rand.nextInt(8) == 0)
        {
            byte var2 = 1;

            if (this.rand.nextInt(32) == 0)
            {
                var2 = 4;
            }

            }
       

        for (int var5 = 0; var5 < 8; ++var5)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isClient)
        {
        	this.explode();
            this.setDead();
        }
    }
    private void explode()
    {
        float var1 = 3.5F;
        //this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, (float)this.field_92057_e, true);
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, var1, true);
        
    }
}
