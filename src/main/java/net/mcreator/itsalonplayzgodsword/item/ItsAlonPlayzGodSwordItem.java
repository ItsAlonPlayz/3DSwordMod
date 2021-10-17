
package net.mcreator.itsalonplayzgodsword.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.itsalonplayzgodsword.procedures.ItsAlonPlayzGodSwordRightClickedOnBlockProcedure;
import net.mcreator.itsalonplayzgodsword.procedures.ItsAlonPlayzGodSwordRightClickedInAirProcedure;
import net.mcreator.itsalonplayzgodsword.procedures.ItsAlonPlayzGodSwordLivingEntityIsHitWithToolProcedure;
import net.mcreator.itsalonplayzgodsword.procedures.ItsAlonPlayzGodSwordEntitySwingsItemProcedure;
import net.mcreator.itsalonplayzgodsword.ItsalonplayzGodSwordModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ItsalonplayzGodSwordModElements.ModElement.Tag
public class ItsAlonPlayzGodSwordItem extends ItsalonplayzGodSwordModElements.ModElement {
	@ObjectHolder("itsalonplayz_god_sword:its_alon_playz_god_sword")
	public static final Item block = null;
	public ItsAlonPlayzGodSwordItem(ItsalonplayzGodSwordModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 22f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7r\u00A7bOnly \u00A76ItsAlonPlayz\u00A7b Can Use This Sword"));
				list.add(new StringTextComponent("\u00A7"));
				list.add(new StringTextComponent("Abilites"));
				list.add(new StringTextComponent("\u00A7"));
				list.add(new StringTextComponent("Lightning Swarm  Right Click To Summon Lightning 10 Blocks Away"));
				list.add(new StringTextComponent("\u00A7"));
				list.add(new StringTextComponent("Fireball Attack  Left Click To Summon Fireballs"));
				list.add(new StringTextComponent("\u00A7"));
				list.add(new StringTextComponent("Netherite Magic  Right Click On A Block To Turn It Into A Netherite Block"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ItsAlonPlayzGodSwordRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public ActionResultType onItemUse(ItemUseContext context) {
				ActionResultType retval = super.onItemUse(context);
				World world = context.getWorld();
				BlockPos pos = context.getPos();
				PlayerEntity entity = context.getPlayer();
				Direction direction = context.getFace();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				ItemStack itemstack = context.getItem();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ItsAlonPlayzGodSwordRightClickedOnBlockProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ItsAlonPlayzGodSwordLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ItsAlonPlayzGodSwordEntitySwingsItemProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("its_alon_playz_god_sword"));
	}
}
