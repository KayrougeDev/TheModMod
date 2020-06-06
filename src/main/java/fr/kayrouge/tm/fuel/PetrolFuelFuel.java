
package fr.kayrouge.tm.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import fr.kayrouge.tm.block.PetrolBlock;
import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class PetrolFuelFuel extends TmModElements.ModElement {
	public PetrolFuelFuel(TmModElements instance) {
		super(instance, 66);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PetrolBlock.block, (int) (1)).getItem())
			event.setBurnTime(30000);
	}
}
