
package fr.kayrouge.tm.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class UncompresedBedrockBlock extends TmModElements.ModElement {
	@ObjectHolder("tm:uncompresed_bedrock")
	public static final Block block = null;
	public UncompresedBedrockBlock(TmModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MainTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.GROUND).hardnessAndResistance(2.5999999999999996f, 29f).lightValue(2)
					.harvestLevel(3).harvestTool(ToolType.PICKAXE));
			setRegistryName("uncompresed_bedrock");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
