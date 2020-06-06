
package fr.kayrouge.tm.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import fr.kayrouge.tm.procedures.AntiFallingBootsBootsTickEventProcedure;
import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class AntiFallingBootsItem extends TmModElements.ModElement {
	@ObjectHolder("tm:anti_falling_bootshelmet")
	public static final Item helmet = null;
	@ObjectHolder("tm:anti_falling_bootsbody")
	public static final Item body = null;
	@ObjectHolder("tm:anti_falling_bootslegs")
	public static final Item legs = null;
	@ObjectHolder("tm:anti_falling_bootsboots")
	public static final Item boots = null;
	public AntiFallingBootsItem(TmModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 21;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{6, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 11;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "anti_falling_boots";
			}

			public float getToughness() {
				return 2.3000000000000003f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(MainTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tm:textures/models/armor/darkdiamondarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					AntiFallingBootsBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("anti_falling_bootsboots"));
	}
}
