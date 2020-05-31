
package fr.kayrouge.tm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.kayrouge.tm.itemgroup.EnergyTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class EnergyCoreItem extends TmModElements.ModElement {
	@ObjectHolder("tm:energy_core")
	public static final Item block = null;
	public EnergyCoreItem(TmModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(EnergyTabItemGroup.tab).maxStackSize(8));
			setRegistryName("energy_core");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0.4F;
		}
	}
}
