
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

import fr.kayrouge.tm.procedures.DarkDiamondArmorArmorHelmetTickEventProcedure;
import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class DarkDiamondArmorArmorItem extends TmModElements.ModElement {
	@ObjectHolder("tm:dark_diamond_armorhelmet")
	public static final Item helmet = null;
	@ObjectHolder("tm:dark_diamond_armorbody")
	public static final Item body = null;
	@ObjectHolder("tm:dark_diamond_armorlegs")
	public static final Item legs = null;
	@ObjectHolder("tm:dark_diamond_armorboots")
	public static final Item boots = null;
	public DarkDiamondArmorArmorItem(TmModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 45;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{10, 14, 16, 10}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 16;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkdiamondItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "dark_diamond_armor";
			}

			public float getToughness() {
				return 2.6999999999999997f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(MainTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tm:textures/models/armor/darkdiamondarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					DarkDiamondArmorArmorHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("dark_diamond_armorhelmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(MainTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tm:textures/models/armor/darkdiamondarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("dark_diamond_armorbody"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(MainTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tm:textures/models/armor/darkdiamondarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("dark_diamond_armorlegs"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(MainTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "tm:textures/models/armor/darkdiamondarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("dark_diamond_armorboots"));
	}
}
