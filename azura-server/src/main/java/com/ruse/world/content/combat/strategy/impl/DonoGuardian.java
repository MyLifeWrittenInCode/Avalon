package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Graphic;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class DonoGuardian implements CombatStrategy {

	private static final Animation MELEE = new Animation(10493);
	private static final Animation MELEE1 = new Animation(2067);
	private static final Animation MELEE2 = new Animation(451);
	@Override
	public boolean canAttack(Character entity, Character victim) {
		return true;
	}

	@Override
	public CombatContainer attack(Character entity, Character victim) {
		return null;
	}

	@Override
	public boolean customContainerAttack(Character entity, Character victim) {
		NPC earthquake = (NPC) entity;
		Player player = (Player) victim;
		Position pos = victim.getPosition().copy();
		earthquake.setChargingAttack(true).getCombatBuilder().setAttackTimer(6);
		earthquake.performAnimation(MELEE1);
		victim.performGraphic(new Graphic(1009, 0));
		TaskManager.submit(new Task(4, earthquake, false) {

			@Override
			public void execute() {
				if (victim.getPosition().sameAs(pos)) {
					if (Misc.getRandom(25) > 15) {
					earthquake.performAnimation(MELEE1);
				} else earthquake.performAnimation(MELEE2);
					victim.performGraphic(new Graphic(1009));
					earthquake.getCombatBuilder()
							.setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));
				}
				earthquake.setChargingAttack(false);
				stop();
			}
		});

		if (Locations.goodDistance(earthquake.getPosition().copy(), victim.getPosition().copy(), 1)
				&& Misc.getRandom(5) > 4) {
				earthquake.performAnimation(MELEE);
			victim.performGraphic(new Graphic(398));
			earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

			victim.performGraphic(new Graphic(398));
			earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

			victim.performGraphic(new Graphic(398));
			earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));
		}
		else if (Locations.goodDistance(earthquake.getPosition().copy(), victim.getPosition().copy(), 1)
				&& Misc.getRandom(5) <= 4) {

			if (Misc.getRandom(25) > 15) {
				earthquake.performAnimation(MELEE1);
			} else earthquake.performAnimation(MELEE2);
			victim.performGraphic(new Graphic(1009));
			earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

		}
		return true;
	}


	@Override
	public int attackDelay(Character entity) {
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		return 5;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MIXED;
	}
}
