package com.ruse.world.content.skill.impl.firemaking;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Skill;
import com.ruse.model.container.impl.Equipment;
import com.ruse.model.movement.MovementQueue;
import com.ruse.util.Misc;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.entity.impl.player.Player;

/**
 * The Firemaking skill
 * 
 * @author Gabriel Hannason
 */

public class Firemaking {

	public static void lightFire(final Player player, int log, final boolean addingToFire, final int amount) {
		if (!player.getClickDelay().elapsed(2000) || player.getMovementQueue().isLockMovement())
			return;
		if (!player.getLocation().isFiremakingAllowed()) {
			player.getPacketSender().sendMessage("You can not light a fire in this area.");
			return;
		}
		boolean objectExists = CustomObjects.objectExists(player.getPosition().copy());
		if (!Dungeoneering.doingOldDungeoneering(player)) {
			if (objectExists && !addingToFire || player.getPosition().getZ() > 0) {
				player.getPacketSender().sendMessage("You can not light a fire here.");
				return;
			}
			if (player.getPosition().getX() == 2848 && player.getPosition().getY() == 3335
					|| player.getPosition().getX() == 2711 && player.getPosition().getY() == 3438) {// fm
				player.getPacketSender().sendMessage("There's already a perfectly good fire here.");
				return;
			}
		}
		final Logdata.logData logData = Logdata.getLogData(player, log);
		if (logData == null)
			return;
		player.getMovementQueue().reset();
		if (objectExists && addingToFire)
			MovementQueue.stepAway(player);
		player.getPacketSender().sendInterfaceRemoval();
		player.setEntityInteraction(null);
		player.getSkillManager().stopSkilling();
		int cycle = 2 + Misc.getRandom(3);
		if (player.getSkillManager().getMaxLevel(Skill.FIREMAKING) < logData.getLevel()) {
			player.getPacketSender()
					.sendMessage("You need a Firemaking level of atleast " + logData.getLevel() + " to light this.");
			return;
		}
		if (!addingToFire) {
			player.getPacketSender().sendMessage("You attempt to light a fire..");
			player.performAnimation(new Animation(733));
			player.getMovementQueue().setLockMovement(true);
		}
		player.setCurrentTask(new Task(addingToFire ? 2 : cycle, player, addingToFire ? true : false) {
			int added = 0;

			@Override
			public void execute() {
				player.getPacketSender().sendInterfaceRemoval();
				if (addingToFire && player.getInteractingObject() == null) { // fire has died
					player.getSkillManager().stopSkilling();
					player.getPacketSender().sendMessage("The fire has died out.");
					return;
				}
				if (player.getEquipment().get(Equipment.RING_SLOT).getId() == 13659 && Misc.getRandom(7) == 1) {
					player.getPacketSender().sendMessage("Your cape has salvaged your log.");
				} else {
					if (player.getSkillManager().skillCape(Skill.FIREMAKING) && Misc.getRandom(10) == 1) {
						player.getPacketSender().sendMessage("Your cape has salvaged your log.");
					} else {
						player.getInventory().delete(logData.getLogId(), 1);
					}
				}
				if (addingToFire) {
					player.performAnimation(new Animation(827));
					if (logData.getLogId() != 23294 || logData.getLogId() != 23294 || logData.getLogId() != 23294) {
						player.getPacketSender().sendMessage("You add some logs to the fire..");
					}
					if (logData.getLogId() == 23294) {
						player.getPacketSender().sendMessage("You burn Celestial scales for x15 Celestial Energy");
						player.getInventory().add(23273, 15);
					} if (logData.getLogId() == 23294 && player.getEquipment().containsAll(14055,14053,14052,14051,14050,18333)) {
						player.getPacketSender().sendMessage("You get x2 Extra Celestial Energy from your armors bonus");
						player.getInventory().add(23273, 2);
					}
					if (logData.getLogId() == 17821) {
						player.getPacketSender().sendMessage("You burn Celestial Mushrooms for x12 Celestial Energy");
						player.getInventory().add(23273, 12);
					}if (logData.getLogId() == 17821 && player.getEquipment().containsAll(14055,14053,14052,14051,14050,18333)) {
						player.getPacketSender().sendMessage("You get x2 Extra Celestial Energy from your armors bonus");
						player.getInventory().add(23273, 2);
					}
					if (logData.getLogId() == 2893) {
						player.getPacketSender().sendMessage("You burn Celestial Bars for x22 Celestial Energy");
						player.getInventory().add(23273, 22);
					} if (logData.getLogId() == 2893 && player.getEquipment().containsAll(14055,14053,14052,14051,14050,18333)) {
						player.getPacketSender().sendMessage("You get x2 Extra Celestial Energy from your armors bonus");
						player.getInventory().add(23273, 2);
					}
					if (logData.getLogId() == 23295) {
						player.getPacketSender().sendMessage("You burn Celestial Rocks for x22 Celestial Energy");
						player.getInventory().add(23273, 22);
					} if (logData.getLogId() == 23295 && player.getEquipment().containsAll(14055,14053,14052,14051,14050,18333)) {
						player.getPacketSender().sendMessage("You get x2 Extra Celestial Energy from your armors bonus");
						player.getInventory().add(23273, 2);
					}
				} else {
					if (!player.getMovementQueue().isMoving()) {
						player.getMovementQueue().setLockMovement(false);
						player.performAnimation(new Animation(65535));
						MovementQueue.stepAway(player);
					}
					CustomObjects.globalFiremakingTask(
							new GameObject(logData.getGameObject(), player.getPosition().copy()), player,
							logData.getBurnTime());
					player.getPacketSender().sendMessage("The fire catches and the logs begin to burn.");
					stop();
				}

				Sounds.sendSound(player, Sound.LIGHT_FIRE);
				player.getSkillManager().addExperience(Skill.FIREMAKING, (int) (logData.getXp()));

				added++;
				if (added >= amount || !player.getInventory().contains(logData.getLogId())) {
					stop();
					if (added < amount && addingToFire && Logdata.getLogData(player, -1) != null
							&& Logdata.getLogData(player, -1).getLogId() != log) {
						player.getClickDelay().reset(0);
						Firemaking.lightFire(player, -1, true, (amount - added));
					}
					return;
				}
			}

			@Override
			public void stop() {
				setEventRunning(false);
				player.performAnimation(new Animation(65535));
				player.getMovementQueue().setLockMovement(false);
			}
		});
		TaskManager.submit(player.getCurrentTask());
		player.getClickDelay().reset(System.currentTimeMillis() + 500);
	}

}