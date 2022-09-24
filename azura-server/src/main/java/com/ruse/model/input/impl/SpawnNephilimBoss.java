package com.ruse.model.input.impl;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.model.input.EnterAmount;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.globalBosses.NephilimSpawnSystem;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
public class SpawnNephilimBoss extends EnterAmount {


	@Override
	public void handleAmount(Player player, int amount) {
		player.getPacketSender().sendInterfaceRemoval();
		int ticketAmount = player.getInventory().getAmount(23257);
		if (ticketAmount > amount) {
			ticketAmount = amount;
		}

		NPC npc = new NPC(9312, new Position(2145, 3302));
		if (World.isNephActive()) {
			player.getPacketSender().sendMessage("@red@Nephilim warrior is already active!");
			return;
		}
		if (ticketAmount <= 0) {
			player.getPacketSender().sendMessage("You don't have any Nephilim tokens in your Inventory!");
			return;
		}
		if (amount > NephilimSpawnSystem.getLeft()) {
			ticketAmount = NephilimSpawnSystem.getLeft();
		}

		player.getInventory().delete(23257, ticketAmount);
		NephilimSpawnSystem.sacrificedCount += ticketAmount;

		player.incrementNephilimBonus(ticketAmount);
		if (NephilimSpawnSystem.sacrificedCount <= 249 && amount > 0) {
			World.sendMessage("@red@<img=1463>[Nephilim Warrior]<img=1463> @epi@" + player.getUsername() + " has contributed " + ticketAmount + " Nephilim tokens.");
			World.sendMessage("@red@<img=1463>[Nephilim Warrior]<img=1463> @blu@" + NephilimSpawnSystem.getLeft() + " @epi@more Nephilim tokens left for Nephilim Warrior spawn.");
			player.getPacketSender().sendMessage("<img=832>@blu@ You will receive a @red@" + player.getNephilimBonus() + "% @blu@Drop rate bonus your next Nephilim kill");
			return;

		}  if (NephilimSpawnSystem.sacrificedCount == 250) {

			String message = "The Nephilim Warrior has appeared ::Nephilim";
			World.register(npc);
			NephilimSpawnSystem.sacrificedCount = 0;
			World.setNephActive(true);

			World.sendMessage("@red@<img=1463>[Nephilim Warrior]<img=1463> @epi@" + player.getUsername() + " has contributed " + ticketAmount + " Nephilim tokens.");
			player.getPacketSender().sendMessage("<img=832>@blu@ You will receive a @red@" + player.getNephilimBonus() + "% @blu@Drop rate bonus your next Nephilim kill");

			if (GameSettings.LOCALHOST == false)
			DiscordMessager.sendNephilimBossLog("");
			World.sendBroadcastMessage("@bla@The Nephilim Warrior has appeared ::Nephilim");
			GameSettings.broadcastMessage = "The Nephilim Warrior has appeared ::Nephilim";
			GameSettings.broadcastTime = 100;
			for (Player players : World.getPlayers()) {
				if (players == null) {
					continue;
				}
				players.getPacketSender().sendBroadCastMessage(message, 100);
			}
		}
	}
}
