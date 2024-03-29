package com.ruse.engine.task.impl;

import com.ruse.engine.task.Task;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.world.content.Consumables;
import com.ruse.world.entity.impl.player.Player;

public class SeraphicPotionTask extends Task {

	public SeraphicPotionTask(Player player) {
		super(1, player, true);
		this.player = player;
	}

	final Player player;

	@Override
	public void execute() {
		if (player == null || !player.isRegistered()) {
			stop();
			return;
		}
		int timer = player.getOverloadPotionTimer();
		if (timer == 600 || timer == 598 || timer == 596 || timer == 594 || timer == 592) {
			player.performAnimation(new Animation(3170));
			player.dealDamage(new Hit(100, Hitmask.RED, CombatIcon.NONE));
		}

		Consumables.overloadIncrease(player, Skill.ATTACK, 1.34);
		Consumables.overloadIncrease(player, Skill.STRENGTH, 1.34);
		Consumables.overloadIncrease(player, Skill.DEFENCE, 1.34);
		Consumables.overloadIncrease(player, Skill.RANGED, 1.34);
		Consumables.overloadIncrease(player, Skill.MAGIC, 1.34);

		player.setOverloadPotionTimer(timer - 1);
		if (player.getOverloadPotionTimer() == 20)
			player.getPacketSender().sendMessage("@red@Your Owner Potion's effect is about to run out.");
		if (player.getOverloadPotionTimer() <= 0 || player.getLocation() == Location.DUEL_ARENA
				|| player.getLocation() == Location.DUNGEONEERING
				|| player.getLocation() == Location.WILDERNESS && player.getRights() != PlayerRights.OWNER) {
			player.getPacketSender().sendMessage("@red@Your Owner Potion's effect has run out.");
			for (int i = 0; i < 7; i++) {
				if (i == 3 || i == 5)
					continue;
				player.getSkillManager().setCurrentLevel(Skill.forId(i), player.getSkillManager().getMaxLevel(i));
			}
			player.setOverloadPotionTimer(0);
			stop();
		}
	}
}
