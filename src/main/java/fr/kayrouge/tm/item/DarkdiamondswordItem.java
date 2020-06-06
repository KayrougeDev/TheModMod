
package fr.kayrouge.tm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class DarkdiamondswordItem extends TmModElements.ModElement {
	@ObjectHolder("tm:darkdiamondsword")
	public static final Item block = null;
	public DarkdiamondswordItem(TmModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1257;
			}

			public float getEfficiency() {
				return 4.5f;
			}

			public float getAttackDamage() {
				return 6.700000000000001f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkdiamondItem.block, (int) (1)));
			}
		}, 3, 3.300000000000001f, new Item.Properties().group(MainTabItemGroup.tab)) {
		}.setRegistryName("darkdiamondsword"));
	}
}
