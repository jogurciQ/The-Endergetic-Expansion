package endergeticexpansion.common.tileentities;

import endergeticexpansion.core.registry.EETileEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class EndStoneCoverTileEntity extends TileEntity {

	public EndStoneCoverTileEntity() {
		super(EETileEntities.ENDSTONE_COVER.get());
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8.0D);
	}
	
	@Override
	public double getMaxRenderDistanceSquared() {
		return super.getMaxRenderDistanceSquared() * 10;
	}

}