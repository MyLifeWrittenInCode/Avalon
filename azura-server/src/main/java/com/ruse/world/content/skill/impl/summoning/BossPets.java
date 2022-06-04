package com.ruse.world.content.skill.impl.summoning;

import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

public class BossPets {

	@Getter
	public enum BossPet {

		// UPGRADABLE PETS
		WOLF_PET(4414, 459, "1% DR Bonus"),
		GORILLA_PET(3001, 460,  "3% DR Bonus"),
		MARIO_PET(1892, 5508 ,  "5% DR Bonus"),
		DONKEY_KONG_PET(1894, 5506 ,  "7% DR Bonus"),
		VEGETA_PET(5001, 461 ,  "10% DR Bonus"),
		YOSHI_PET(3377, 462 ,  "15% DR Bonus"),
		ZORBAK_PET(1906, 11319  ,  "25% DR Bonus"),
		RAICHU_PET(1801, 11318  ,  "50% DR Bonus & 15% DMG Bonus"),

		//Boss pets & Minigame pets
		FALLEN_ANGEL_PET(9013, 22107  ,  "60% DR Bonus & 25% DMG Bonus"),
		FENRIR_PET(9830, 23108, 300,"50% DR Bonus"),
		GREEN_FENRIR_PET(9831, 23109, 300,"50% DR Bonus"),
		RED_FENRIR_PET(9832, 23110,300,"50% DR Bonus"),
		VOTE_PET(8802, 11316,"Doubles your Votes"),
		HELLRAISER(302, 11314,"10% DR Bonus & X2 KC Effect"),
		RAMMUS_PET(9822, 23164, 400,"100% key drop & 50% DR Bonus"),
		DEMON_PET(9819, 23161, 300,"100% key drop & 50% DR Bonus"),
		GOLEM_PET(9821, 23163, 400,"100% key drop & 50% DR Bonus"),
		DRAGON_PET(9820, 23162, 1500,"100% key drop & 50% DR Bonus"),
		IRONS_PET(9016, 22116, "60% DR Bonus"),
		BLOOD_DEMON_PET(204, 23252, "70% DR Bonus & 30% DMG Bonus"),

		;

		BossPet(int npcId, int itemId) {
			this.npcId = npcId;
			this.itemId = itemId;
		}
		BossPet(int npcId, int itemId, String boost) {
			this.npcId = npcId;
			this.itemId = itemId;
			this.boost = boost;
		}
		BossPet(int npcId, int itemId, int zoom, String boost) {
			this.npcId = npcId;
			this.itemId = itemId;
			this.zoom = zoom;
			this.boost = boost;
		}

		public int npcId, itemId, zoom = 800;
		public String boost = "None";

		public static BossPet forId(int itemId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.itemId == itemId) {
					return p;
				}
			}
			return null;
		}

		public static BossPet forSpawnId(int spawnNpcId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.npcId == spawnNpcId) {
					return p;
				}
			}
			return null;
		}
	}

	public static boolean pickup(Player player, NPC npc) {
		BossPet pet = BossPet.forSpawnId(npc.getId());
		if (pet != null) {
			if (player.getInventory().getFreeSlots() < 1) {
				player.getPacketSender().sendMessage("You need a free inventory space to pick up a pet.");
				return false;
			}
			if (player.getSummoning().getFamiliar() != null
					&& player.getSummoning().getFamiliar().getSummonNpc() != null
					&& player.getSummoning().getFamiliar().getSummonNpc().isRegistered()) {
				if (player.getSummoning().getFamiliar().getSummonNpc().getId() == pet.npcId
						&& player.getSummoning().getFamiliar().getSummonNpc().getIndex() == npc.getIndex()) {
					player.getSummoning().unsummon(true, true);
					player.getPacketSender().sendMessage("You pick up your pet.");
					return true;
				} else {
					player.getPacketSender().sendMessage("This is not your pet to pick up.");
				}
			} else {
				player.getPacketSender().sendMessage("This is not your pet to pick up.");
			}
		}
		return false;
	}

}
