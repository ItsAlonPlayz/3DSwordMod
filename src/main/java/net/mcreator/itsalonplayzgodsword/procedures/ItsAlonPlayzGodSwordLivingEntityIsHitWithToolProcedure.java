package net.mcreator.itsalonplayzgodsword.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.itsalonplayzgodsword.ItsalonplayzGodSwordModElements;
import net.mcreator.itsalonplayzgodsword.ItsalonplayzGodSwordMod;

import java.util.Map;

@ItsalonplayzGodSwordModElements.ModElement.Tag
public class ItsAlonPlayzGodSwordLivingEntityIsHitWithToolProcedure extends ItsalonplayzGodSwordModElements.ModElement {
	public ItsAlonPlayzGodSwordLivingEntityIsHitWithToolProcedure(ItsalonplayzGodSwordModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ItsalonplayzGodSwordMod.LOGGER.warn("Failed to load dependency entity for procedure ItsAlonPlayzGodSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"summon lightning_bolt ~ ~ ~");
			}
		}
	}
}
