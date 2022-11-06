package com.ruse.world.content.celestial;

import com.ruse.GameSettings;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

//import com.ruse.tools.discord.DiscordConstant;
//import com.ruse.tools.discord.DiscordManager;

public final class CelestialPortal {

	/*
	 * Project Avalon
	 * Author @Avalon (AlwaysDreaming.ai@gmail.com)
	 * Created on - 6/23/2022
	 */

	public static int TIME = 18000;
	public static Stopwatch timer = new Stopwatch().reset();
	public static PortalSpawn PORTAL = null;
	private static LocationData PREVIOUS_LOC = null;
	private static boolean firstTime = true;
	public static int tick = 0;

	public static void handleTrueAction(Player player, GameObject object) {

		if (player.getCelestial() == true) {
			if (PORTAL != null) {
				TeleportHandler.teleportPlayer(player, new Position(4257, 5598),
						player.getSpellbook().getTeleportType());
			} else
				DialogueManager.sendStatement(player, "The Realm of Fantasy is currently closed.");
		} else
			DialogueManager.sendStatement(player, "You need to unlock the Realm of Fantasy before using this command!");

		if (player.getCelestial() == false && player.getInventory().contains(13379, 2)) {
			DialogueManager.start(player, CelestialDialogues.sacrifice(player));
		}	else if (player.getCelestial() == false) {
			DialogueManager.sendStatement(player, "You need to first unlock the Realm of Fantasy!");
		}
	}

	public static void handleTrueAction(Player player) {

		if (player.getCelestial() == true) {
			if (PORTAL != null) {
				TeleportHandler.teleportPlayer(player, new Position(4257, 5598),
						player.getSpellbook().getTeleportType());
			} else
				DialogueManager.sendStatement(player, "The Realm of Fantasy is currently closed.");
		} else
			DialogueManager.sendStatement(player, "You need to unlock the Realm of Fantasy before using this command!");

		if (player.getCelestial() == false && player.getInventory().contains(13379, 2)) {
			DialogueManager.start(player, CelestialDialogues.sacrifice(player));
		}	else if (player.getCelestial() == false) {
			DialogueManager.sendStatement(player, "You need to first unlock the Realm of Fantasy!");
		}
	}

	public static class PortalSpawn {

		public PortalSpawn(GameObject object, LocationData location) {
			this.object = object;
			this.portalLocation = location;
		}

		private GameObject object;
		private LocationData portalLocation;

		public GameObject getChestObject() {
			return object;
		}

		public LocationData getPortalLocation() {
			return portalLocation;
		}
	}


	public static enum CelestialZoneDef {

		CELESTIAL_PORTAL("Realm of Fantasy", 4388);

		private String chestName;
		private int id;

		private CelestialZoneDef(String chestName, int id) {
			this.chestName = chestName;
			this.id = id;
		}

		public int getId() {
			return id;
		}


		private static final Map<Integer, CelestialZoneDef> celestialPortal = new HashMap<Integer, CelestialZoneDef>();

		public static CelestialZoneDef forId(int id) {
			return celestialPortal.get(id);
		}

		static {
			for (CelestialZoneDef w : CelestialZoneDef.values())
				celestialPortal.put(w.id, w);
		}
	}

	public static enum LocationData {
		CELESTIAL_HOME(new Position(2651, 4002), "South of home"),
		;
		private LocationData(Position pos, String loc) {
			this.pos = pos;
			this.loc = loc;
		}

		private Position pos;
		private String loc;
	}

	public static LocationData getRandom() {
		LocationData celestialPortal = LocationData.values()[Misc.getRandom(LocationData.values().length - 1)];
		return celestialPortal;
	}

	public static CelestialZoneDef getPortal() {
		CelestialZoneDef celestialPortal = CelestialZoneDef.values()[Misc.getRandom(CelestialZoneDef.values().length - 1)];
		return celestialPortal;
	}

	public static void spawn() {

		if (PORTAL == null) {
			PORTAL = new PortalSpawn(new GameObject(4388, new Position(2931, 4124) ), PREVIOUS_LOC);
			CustomObjects.spawnGlobalObject(PORTAL.object);
			if (GameSettings.LOCALHOST == false)
		DiscordMessager.sendCelestialLog("");
		World.sendMessage("<img=832> The Realm of Fantasy has opened for 1 hour (Realm of Fantasy members only)");
		}

	}

	public static LocationData getLocation() {
		return PREVIOUS_LOC;
	}

	public static void despawn(boolean respawn) {

		if (respawn) {
			timer.reset(0);
		} else {
			timer.reset();
		}
		if (PORTAL != null) {
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}

				if (p.getInteractingObject() != null && p.getInteractingObject().getId() == PORTAL.object.getId()) {
					PREVIOUS_LOC = null;
					p.performAnimation(new Animation(65535));
					p.getPacketSender().sendClientRightClickRemoval();
					p.getSkillManager().stopSkilling();
					p.getPacketSender().sendInterfaceRemoval();
				}
			}
			World.sendMessage("<img=832> The Realm of Fantasy is now closed and will open again in 2 hours.");
			CelestialZoneTask.startTask();
			tick = 0;
			PORTAL = null;
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}
				PlayerPanel.refreshPanel(p);
			}
		}
	}
}