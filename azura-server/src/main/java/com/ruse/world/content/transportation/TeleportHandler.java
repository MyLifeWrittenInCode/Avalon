package com.ruse.world.content.transportation;

import com.ruse.GameSettings;
import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Graphic;
import com.ruse.model.Position;
import com.ruse.world.content.Kraken;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.entity.impl.player.Player;
import com.ruse.world.instance.MapInstance;

public class TeleportHandler {

	public static void teleportPlayer(final Player player, final Position targetLocation,
			final TeleportType teleportType) {
		if (teleportType != TeleportType.LEVER) {
			if (!checkReqs(player, targetLocation)) {
				return;
			}
		}
		/*if (PlayerPunishment.Jail.isJailed(player.getUsername())) {
			player.getPacketSender().sendMessage("As a jailed person. You cannot do this.");
			return;
		}*/

		MapInstance instance = player.getMapInstance();
		if (instance != null && !instance.canTeleport(player, targetLocation)) {
			player.sendMessage("You cannot teleport in this instance.");
			return;
		}
		if (!player.getControllerManager().processTeleport(teleportType, targetLocation)) {
			player.sendMessage("You cannot teleport right now.");
			return;
		}
		if (!player.getClickDelay().elapsed(4500) || player.getMovementQueue().isLockMovement())
			return;
		player.setTeleporting(true).getMovementQueue().setLockMovement(true).reset();
		cancelCurrentActions(player);
		player.performAnimation(teleportType.getStartAnimation());
		player.performGraphic(teleportType.getStartGraphic());
		Sounds.sendSound(player, Sound.TELEPORT);
		player.motivationalMessages.startTask();
		TaskManager.submit(new Task(1, player, true) {
			int tick = 0;

			@Override
			public void execute() {
				switch (teleportType) {
				case LEVER:
					if (tick == 0)
						player.performAnimation(new Animation(2140));
					else if (tick == 2) {
						player.performAnimation(new Animation(8939, 20));
						player.performGraphic(new Graphic(1576));
					} else if (tick == 4) {
						player.motivationalMessages.startTask();
						player.performAnimation(new Animation(8941));
						player.performGraphic(new Graphic(1577));
						player.moveTo(targetLocation).setPosition(targetLocation);
						if (player.getPosition() == (targetLocation))
							player.motivationalMessages.endTask();
						player.getMovementQueue().setLockMovement(false).reset();
						stop();
					}
					break;
				default:
					if (tick == teleportType.getStartTick()) {
						player.motivationalMessages.startTask();
						cancelCurrentActions(player);
						player.performAnimation(teleportType.getEndAnimation());
						player.performGraphic(teleportType.getEndGraphic());

						if (Dungeoneering.doingOldDungeoneering(player)) {
							final Position dungEntrance = player.getMinigameAttributes().getDungeoneeringAttributes()
									.getParty().getDungeoneeringFloor().getEntrance().copy()
									.setZ(player.getPosition().getZ());
							player.moveTo(dungEntrance).setPosition(dungEntrance);
						} else {
								player.moveTo(targetLocation).setPosition(targetLocation);
						}
						if(!targetLocation.sameAs(GameSettings.DEFAULT_POSITION)) {
							player.lastTeleport = targetLocation;
						}

						onArrival(player, targetLocation);
						player.setTeleporting(false);
						if (player.getPosition() == (targetLocation))
							player.motivationalMessages.endTask();
					} else if (tick == teleportType.getStartTick() + 3) {
						player.getMovementQueue().setLockMovement(false).reset();
					} else if (tick == teleportType.getStartTick() + 4)
						stop();
					break;
				}
				tick++;
			}

			@Override
			public void stop() {
				setEventRunning(false);
				player.setTeleporting(false);
				player.getClickDelay().reset(0);
			}
		});
		player.getClickDelay().reset();
	}

	public static void onArrival(Player player, Position targetLocation) {
		if (targetLocation.getX() == 3683 && targetLocation.getY() == 9888) { // Kraken
			Kraken.enter(player);
		}
	}

	public static boolean interfaceOpen(Player player) {
		if (player.getInterfaceId() > 0 && player.getInterfaceId() != 50100) {
			player.getPacketSender().sendMessage("Please close the interface you have open before opening another.");
			return true;
		}
		return false;
	}

	public static boolean checkReqs(Player player, Position targetLocation) {
		if (player.getConstitution() <= 0)
			return false;
		if (player.getTeleblockTimer() > 0) {
			player.getPacketSender().sendMessage("A magical spell is blocking you from teleporting.");
			return false;
		}

		if (player.getLocation() != null && !player.getLocation().canTeleport(player)) {
			return false;
		}
		if ((player.isPlayerLocked() || player.isGroupIronmanLocked()) || player.isCrossingObstacle()) {
			player.getPacketSender().sendMessage("You cannot teleport right now.");
			return false;
		}
		return true;
	}

	public static void cancelCurrentActions(Player player) {
		player.getPacketSender().sendInterfaceRemoval();
		player.setTeleporting(false);
		player.setWalkToTask(null);
		player.setInputHandling(null);
		player.getSkillManager().stopSkilling();
		player.setEntityInteraction(null);
		player.getMovementQueue().setFollowCharacter(null);
		player.getCombatBuilder().cooldown(false);
		player.setResting(false);
	}
}
