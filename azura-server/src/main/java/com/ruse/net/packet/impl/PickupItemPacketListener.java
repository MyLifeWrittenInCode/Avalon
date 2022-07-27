package com.ruse.net.packet.impl;

import com.ruse.engine.task.impl.WalkToTask;
import com.ruse.engine.task.impl.WalkToTask.FinalizedMovementTask;
import com.ruse.model.GroundItem;
import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.model.container.impl.Equipment;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.GroundItemManager;
import com.ruse.world.entity.impl.player.Player;

/**
 * This packet listener is used to pick up ground items that exist in the world.
 * 
 * @author relex lawl
 */

public class PickupItemPacketListener implements PacketListener {

	@Override
	public void handleMessage(final Player player, Packet packet) {
		final int y = packet.readLEShort();
		final int itemId = packet.readShort();
		final int x = packet.readLEShort();
		if (player.isTeleporting())
			return;

		if (player.getCombatBuilder().isAttacking()) {
			player.getCombatBuilder().cooldown(false);
		}
		final Position position = new Position(x, y, player.getPosition().getZ());
		if (!player.getLastItemPickup().elapsed(500))
			return;
		if (player.getConstitution() <= 0 || player.isTeleporting())
			return;
		player.setWalkToTask(new WalkToTask(player, position, 1, new FinalizedMovementTask() {
			@Override
			public void execute() {
				if (Math.abs(player.getPosition().getX() - x) > 25 || Math.abs(player.getPosition().getY() - y) > 25) {
					player.getMovementQueue().reset();
					return;
				}

				boolean canPickup = Misc.canAddItemToInventory(player, itemId);
				if (!canPickup) {
					player.getInventory().full();
					return;
				}
				GroundItem gItem = GroundItemManager.getGroundItem(player, new Item(itemId), position);
				if (!player.getControllerManager().canTakeItem(gItem)) {
					return;
				}

				if (itemId == 10537 && !player.getEquipment().contains(1580)) {
					player.getPacketSender().sendMessage("This Omega egg is too hot. Ice gloves could help.");
					return;
				}

				if (itemId == 10537 && player.getEquipment().contains(1580) && player.getQuestTwoStep2() == false) {
					player.setQuestTwoStep2(true);
					player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Obtain the Omega Egg");
				}
				if (itemId == 7546 && !player.getEquipment().contains(4168)) {
					player.getPacketSender().sendMessage("The rancid smell is too much, try wearing nose plugs first.");
					return;
				}
				if (itemId == 7546 && player.getQuestTwoStep3() == false) {
					player.setQuestTwoStep3(true);
					player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Obtain Rancid flour");
				}
				if (itemId == 7509 && player.getEquipment().forSlot(Equipment.HANDS_SLOT).getId() != 1580) {
					player.getPacketSender().sendMessage("This rock cake is too hot. Ice gloves could help.");
					return;
				}
				if (gItem != null) {
					if (player.getInventory().getAmount(gItem.getItem().getId())
							+ gItem.getItem().getAmount() > Integer.MAX_VALUE
							|| player.getInventory().getAmount(gItem.getItem().getId())
									+ gItem.getItem().getAmount() <= 0) {
						player.getPacketSender()
								.sendMessage("You cannot hold that amount of this item. Clear your inventory!");
						return;
					}
					GroundItemManager.pickupGroundItem(player, new Item(itemId),
							new Position(x, y, player.getPosition().getZ()));
				}
			}
		}));
	}
}
