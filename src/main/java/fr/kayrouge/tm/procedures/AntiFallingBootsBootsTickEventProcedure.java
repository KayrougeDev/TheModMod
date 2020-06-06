package fr.kayrouge.tm.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import fr.kayrouge.tm.TmModElements;

@TmModElements.ModElement.Tag
public class AntiFallingBootsBootsTickEventProcedure extends TmModElements.ModElement {
	public AntiFallingBootsBootsTickEventProcedure(TmModElements instance) {
		super(instance, 53);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntiFallingBootsBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) (20 + 2), (int) 2, (false), (false)));
	}
}
