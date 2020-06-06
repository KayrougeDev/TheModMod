package fr.kayrouge.tm.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.BlockState;

import fr.kayrouge.tm.block.RFcableOFFBlock;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class IronGeneratorUpdateTickProcedure extends TmModElements.ModElement {
	public IronGeneratorUpdateTickProcedure(TmModElements instance) {
		super(instance, 46);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure IronGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure IronGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure IronGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IronGeneratorUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) > 20)) {
			if (!world.isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world, x, (y + 1), z, new ItemStack(Items.DIAMOND, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
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
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) - 20));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == RFcableOFFBlock.block.getDefaultState().getBlock())) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) < 40)) {
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
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) + (new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) (z - 1)), "energy"))));
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
		}
	}
}
