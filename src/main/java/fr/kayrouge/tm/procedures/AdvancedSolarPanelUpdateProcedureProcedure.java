package fr.kayrouge.tm.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import fr.kayrouge.tm.block.RFcableOFFBlock;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class AdvancedSolarPanelUpdateProcedureProcedure extends TmModElements.ModElement {
	public AdvancedSolarPanelUpdateProcedureProcedure(TmModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AdvancedSolarPanelUpdateProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AdvancedSolarPanelUpdateProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AdvancedSolarPanelUpdateProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AdvancedSolarPanelUpdateProcedure!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == RFcableOFFBlock.block.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("energy", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "energy")) + 3));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
