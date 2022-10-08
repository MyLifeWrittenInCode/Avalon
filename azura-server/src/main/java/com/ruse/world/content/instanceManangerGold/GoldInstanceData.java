package com.ruse.world.content.instanceManangerGold;

import com.ruse.model.Position;
import com.ruse.model.RegionInstance.RegionInstanceType;

/**
 * 
 * @author Adam_#6723
 *
 */

public enum GoldInstanceData {

	EMBER_GIANTS(125071, 9838, "Ember Giant", 35, new int[] { 19624 },
			"Ember Giant",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TREE_BASILISK(125072, 1718, "Tree Basilisk", 35, new int[] { 19624 },
			"Tree Basilisk",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	AQUANITE(125073, 9172, "Aquanite", 35, new int[] { 19624 },
			"Aquanite",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GIANT_SPIDER(125074, 117, "Arachne", 35, new int[] { 19624 },
			"Arachne",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	CASH_DRAGONS(125075, 500, "Cash Dragon", 35, new int[] { 19624 },
			"Cash Dragon",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	DEMON_GODDESS(125076, 501, "Demon Goddess", 35, new int[] { 19624 },
			"Demon Goddess",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ENERGY_SKELETONS(125077, 503, "Energy Skeleton", 35, new int[] { 19624 },
			"Energy Skeleton",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TUROTHS(125078, 1627, "Turoth", 35, new int[] { 19624 },
			"Turoth",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	LORD(125079, 603, "Lord", 35, new int[] { 19624 },
			"Lord",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHADOW_HUNTERS(125080, 12843, "Shadow Hunter", 35, new int[] { 19624 },
			"Shadow Hunter",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GOLEM(125081, 53, "Jynx Golem", 35, new int[] { 19624 },
			"Jynx Golem",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHETANI(125082, 8018, "Shetani", 35, new int[] { 19624 },
			"Shetani",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TITANIUM_RIPPER(125083, 13635, "Titanium Ripper", 35, new int[] { 19624 },
			"Titanium Ripper",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TITAN(125084, 8008, "Avatar Titan", 35, new int[] { 19624 },
			"Avatar Titan",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	WYVERNS(125085, 3308, "Legendary Wyvern", 3308, new int[] { 19624 },
			"Legendary Wyvern",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ONI(125086, 3117, "Oni", 3308, new int[] { 19624 },
			"Oni",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHENRON(125087, 201, "Shenron", 3308, new int[] { 19624 },
			"Shenron",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SUBZERO(125088, 202, "SubZero", 3308, new int[] { 19624 },
			"SubZero",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ZEUS(125089, 203, "Zeus", 3308, new int[] { 19624 },
			"Zeus",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	IPOTANE(125090, 8010, "Ipotane", 3308, new int[] { 19624 },
			"Ipotane",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	VINDICTA(125091, 9807, "Vindicta", 3308, new int[] { 19624 },
			"Vindicta",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	BORK(125092, 7134, "Bork", 3308, new int[] { 19624 },
			"Bork",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	HANTO(125093, 250, "Hanto warrior", 3308, new int[] { 19624 },
			"Hanto warrior",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	RADITZ(125094, 449, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GOKU(125095, 452, "Goku", 3308, new int[] { 19624 },
			"Goku",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	BOTANIC(125096, 2342, "Botanic Guardian", 3308, new int[] { 19624 },
			"Botanic Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ENRAGED_GUARDIAN(125097, 2949, "Enraged Guardian", 3308, new int[] { 19624 },
			"Enraged Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ELEMENTAL_GUARDIAN(125098, 505, "Elemental Guardian", 3308, new int[] { 19624 },
			"Elemental Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	INNUYASHA(125099, 185, "Inuyasha", 3308, new int[] { 19624 },
			"Inuyasha",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TOLOROKOTH(125100, 6430, "Tolrokoth", 3308, new int[] { 19624 },
			"Tolrokoth",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_1(-125101, 9116, "Faceless Magician", 3308, new int[] { 19624 },
			"Faceless Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_2(-125102, 9117, "Lotus Magician", 3308, new int[] { 19624 },
			"Lotus Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_3(-125103, 9118, "Shadow Magician", 3308, new int[] { 19624 },
			"Shadow Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),

	;

	GoldInstanceData(int buttonid, int npcid, String text, int endamount, int rewards[], String name, Position position,
					 RegionInstanceType region) {
		this.buttonid = buttonid;
		this.npcid = npcid;
		this.text = text;
		this.endamount = endamount;
		this.rewards = rewards;
		this.name = name;
		this.position = position;
		this.region = region;
	}

	private Position position;
	private RegionInstanceType region;

	public RegionInstanceType getRegion() {
		return region;
	}

	public void setRegion(RegionInstanceType region) {
		this.region = region;
	}

	public Position getPosition() {
		return position;
	}

	private int npcid, endamount, taskNumber, buttonid;

	public int getButtonid() {
		return buttonid;
	}

	private int amount;
	private int rewards[];

	public int[] getRewards() {
		return rewards;
	}

	private String text, name, weakness;

	public int getAmount() {
		return amount;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public int getEndamount() {
		return endamount;
	}

	public void setEndamount(int endamount) {
		this.endamount = endamount;
	}

	public String getName() {
		return name;
	}

	public int getNpcid() {
		return npcid;
	}

	public String getText() {
		return text;
	}
}
