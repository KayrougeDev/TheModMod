
package fr.kayrouge.tm.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import fr.kayrouge.tm.itemgroup.MainTabItemGroup;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class CreeperTrollDiscItem extends TmModElements.ModElement {
	@ObjectHolder("tm:creeper_troll_disc")
	public static final Item block = null;
	public CreeperTrollDiscItem(TmModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
					new Item.Properties().group(MainTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("creeper_troll_disc");
		}
	}
}
