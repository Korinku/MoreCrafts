package me.korinku.mocr.content.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class ThrowableTNTEntity extends ThrownItemEntity {

	public ThrowableTNTEntity(EntityType<? extends ThrowableTNTEntity> entityType, World world) {
		super((EntityType<? extends ThrownItemEntity>) entityType, world);
	}

	public ThrowableTNTEntity(World world, LivingEntity owner) {
		super((EntityType<? extends ThrownItemEntity>) EntityType.SNOWBALL, owner, world);
	}

	public ThrowableTNTEntity(World world, double x, double y, double z) {
		super((EntityType<? extends ThrownItemEntity>) EntityType.SNOWBALL, x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return Items.TNT;
	}

	private ParticleEffect getParticleParameters() {
		ItemStack itemStack = this.getItem();
		return itemStack.isEmpty() ? ParticleTypes.EXPLOSION
				: new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
	}

	@Override
	public void handleStatus(byte status) {
		if (status == 3) {
			ParticleEffect particleEffect = this.getParticleParameters();
			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
			}
		}
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		entity.getWorld().createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), 3.0F,
				false, DestructionType.BREAK);
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.createExplosion(null, this.getX(), this.getY(), this.getZ(), 3.0F,
					false, DestructionType.BREAK);
			this.world.sendEntityStatus(this, (byte) 3);
			this.discard();
		}
	}
}
