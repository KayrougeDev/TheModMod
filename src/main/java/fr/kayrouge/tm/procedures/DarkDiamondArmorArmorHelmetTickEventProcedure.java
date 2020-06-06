package fr.kayrouge.tm.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class DarkDiamondArmorArmorHelmetTickEventProcedure extends TmModElements.ModElement {
	public DarkDiamondArmorArmorHelmetTickEventProcedure(TmModElements instance) {
		super(instance, 52);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DarkDiamondArmorArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) (20 * 11), (int) 1, (false), (false)));
	}
}
