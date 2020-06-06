package fr.kayrouge.tm.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.function.Supplier;
import java.util.Map;
import java.util.Iterator;

import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class VoidItemGuiClearProcedure extends TmModElements.ModElement {
	public VoidItemGuiClearProcedure(TmModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VoidItemGuiClear!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			Container _current = ((ServerPlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("tm:void_advancement"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
