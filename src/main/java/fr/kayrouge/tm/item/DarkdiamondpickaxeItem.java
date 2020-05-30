
package fr.kayrouge.tm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class DarkdiamondpickaxeItem extends TmModElements.ModElement {
	@ObjectHolder("tm:darkdiamondpickaxe")
	public static final Item block = null;
	public DarkdiamondpickaxeItem(TmModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2659;
			}

			public float getEfficiency() {
				return 11.5f;
			}

			public float getAttackDamage() {
				return 1.6f;
			}

			public int getHarvestLevel() {
				return 13;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkdiamondItem.block, (int) (1)));
			}
		}, 1, -3.4f, new Item.Properties().group(MainTabItemGroup.tab)) {
		}.setRegistryName("darkdiamondpickaxe"));
	}
}
