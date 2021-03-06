package endergeticexpansion.common.tileentities.boof;

import java.util.List;

import endergeticexpansion.common.blocks.poise.boof.DispensedBoofBlock;
import endergeticexpansion.core.registry.EETileEntities;
import endergeticexpansion.core.registry.other.EETags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class DispensedBoofTileEntity extends TileEntity implements ITickableTileEntity {
	private int ticksExisted;
	
	public DispensedBoofTileEntity() {
		super(EETileEntities.BOOF_BLOCK_DISPENSED.get());
	}

	@Override
	public void tick() {
		this.ticksExisted++;
		
		AxisAlignedBB bb = new AxisAlignedBB(this.pos).grow(0.1F, 0.1F, 0.1F);
		List<Entity> entities = this.world.getEntitiesWithinAABB(Entity.class, bb);
		entities.removeIf((entity) -> EETags.EntityTypes.BOOF_BLOCK_RESISTANT.contains(entity.getType()));
		
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			
			if(this.getBlockState().get(DispensedBoofBlock.FACING) == Direction.UP) {
				entity.addVelocity(MathHelper.sin((float) (entity.rotationYaw * Math.PI / 180.0F)) * 0.1F * 0.1F, 0.25D, -MathHelper.cos((float) (entity.rotationYaw * Math.PI / 180.0F)) * 0.1F * 0.1F);
			} else if(this.getBlockState().get(DispensedBoofBlock.FACING) == Direction.DOWN) {
				entity.addVelocity(MathHelper.sin((float) (entity.rotationYaw * Math.PI / 180.0F)) * 0.1F * 0.1F, -0.45D, -MathHelper.cos((float) (entity.rotationYaw * Math.PI / 180.0F)) * 0.1F * 0.1F);
			} else {
				entity.addVelocity(MathHelper.sin((float) (entity.rotationYaw * Math.PI / 180.0F)) * 3F * 0.1F, 0.45D, -MathHelper.cos((float) (entity.rotationYaw * Math.PI / 180.0F)) * 3F * 0.1F);
			}
		}
		
		if(this.ticksExisted >= 10) {
			this.getWorld().setBlockState(this.pos, Blocks.AIR.getDefaultState());
		}
	}
}