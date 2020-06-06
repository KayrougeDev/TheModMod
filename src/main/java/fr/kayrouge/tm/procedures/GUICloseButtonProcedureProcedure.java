package fr.kayrouge.tm.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class GUICloseButtonProcedureProcedure extends TmModElements.ModElement {
	public GUICloseButtonProcedureProcedure(TmModElements instance) {
		super(instance, 59);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GUICloseButtonProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
