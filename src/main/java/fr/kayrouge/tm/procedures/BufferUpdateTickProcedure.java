package fr.kayrouge.tm.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import fr.kayrouge.tm.block.RFcableOFFBlock;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class BufferUpdateTickProcedure extends TmModElements.ModElement {
	public BufferUpdateTickProcedure(TmModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BufferUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BufferUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BufferUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BufferUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == RFcableOFFBlock.block.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
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
					}.getValue(new BlockPos((int) x, (int) y, (int) (z - 1)), "energy")) + (new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy"))));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("energy", 0);
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == RFcableOFFBlock.block.getDefaultState().getBlock())) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "energy")) < 4)) {
				if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) > 4)) {
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
							}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "energy")) + 4));
						world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
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
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) - 4));
						world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
		}
	}
}
