package endergeticexpansion.common.world.features.corrock;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

public class FeatureCorrockGroundPatch extends Feature<SphereReplaceConfig> {
	
	public FeatureCorrockGroundPatch(Function<Dynamic<?>, ? extends SphereReplaceConfig> config) {
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, SphereReplaceConfig config) {
		int i = 0;
		int radius = rand.nextInt(config.radius - 2) + 2;

		for(int x = pos.getX() - radius; x <= pos.getX() + radius; x++) {
			for(int z = pos.getZ() - radius; z <= pos.getZ() + radius; z++) {
				int radiusXDistance = x - pos.getX();
				int radiusZDistance = z - pos.getZ();
				int distance = radiusXDistance * radiusXDistance + radiusZDistance * radiusZDistance;
				if(distance <= radius * radius) {
					for(int y = pos.getY() - config.ySize; y <= pos.getY() + config.ySize; y++) {
						BlockPos blockpos = new BlockPos(x, y, z);
						BlockState blockstate = worldIn.getBlockState(blockpos);

						for(BlockState blockstate1 : config.targets) {
							if (blockstate1.getBlock() == blockstate.getBlock() && (distance == radius * radius ? rand.nextFloat() < 0.5F : true)) {
								worldIn.setBlockState(blockpos, config.state, 2);
								i++;
								break;
							}
						}
					}
				}
			}
		}
		return i > 0;
	}

}