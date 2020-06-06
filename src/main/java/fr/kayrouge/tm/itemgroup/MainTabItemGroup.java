
package fr.kayrouge.tm.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class MainTabItemGroup extends TmModElements.ModElement {
	public MainTabItemGroup(TmModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmain_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.ANVIL, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
