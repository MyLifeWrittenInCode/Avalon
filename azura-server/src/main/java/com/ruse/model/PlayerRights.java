package com.ruse.model;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Store;

/**
 * Represents a player's privilege rights.
 * 
 * @author Gabriel Hannason
 */

public enum PlayerRights {

	PLAYER(-1, null, 1 ),
	MODERATOR(-1, "<col=20B2AA><shad=0>", 1 ),
	ADMINISTRATOR(-1, "@yel@<shad=0>", 1 ),
	ONYX_DONATOR(-1, "@bla@<shad=0>", 1 ),
	OWNER(-1, "<col=0><shad=B40404>", 1),
	HELPER(-1, "<col=0><shad=FFFFFF>", 1),
	SAPPHIRE_DONATOR(60, "@blu@<shad=0>", 1),
	EMERALD_DONATOR(45, "@gre@<shad=0>", 1),
	RUBY_DONATOR(30, "@red@<shad=0>", 1),
	DIAMOND_DONATOR(15, "@whi@<shad=0>", 1),
	YOUTUBER(-1, "<col=CD201F><shad=ffffff>", 1),
	CRAP(-1, "<col=0><shad=FFFFFF>", 1),
	SUPPORT(-1, "<col=FFFFFF><shad=0>", 1),
	ZENYTE_DONATOR(-1, "@bla@<shad=0>", 1),
	TANZANITE_DONATOR(10, "@bla@<shad=0>", 1),
	NULL_(-1, "@or2@<shad=0>", 1),
	NULL_1(-1, "@or2@<shad=0>", 1),
	NULL_2(-1, "@or2@<shad=0>", 1),
	COMMUNITY_MANAGER(5, "@or2@<shad=0>", 1);

	PlayerRights(int yellDelaySeconds, String yellHexColorPrefix,
			double experienceGainModifier) {
		this.yellDelay = yellDelaySeconds;
		this.yellHexColorPrefix = yellHexColorPrefix;
		this.experienceGainModifier = experienceGainModifier;
	}

	private static final ImmutableSet<PlayerRights> STAFF = Sets.immutableEnumSet(HELPER, SUPPORT, MODERATOR,
			ADMINISTRATOR, OWNER,COMMUNITY_MANAGER);
	private static final ImmutableSet<PlayerRights> MEMBERONLY = Sets.immutableEnumSet(SAPPHIRE_DONATOR, EMERALD_DONATOR,
			DIAMOND_DONATOR, RUBY_DONATOR, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> REGULARDONATORONLY = Sets.immutableEnumSet(SAPPHIRE_DONATOR, EMERALD_DONATOR,
			DIAMOND_DONATOR, RUBY_DONATOR, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> SUPERDONATORONLY = Sets.immutableEnumSet(EMERALD_DONATOR,
			DIAMOND_DONATOR, RUBY_DONATOR, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> EXTREMEDONATORONLY = Sets.immutableEnumSet(DIAMOND_DONATOR,
			RUBY_DONATOR, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> SPONSORDONATORONLY = Sets.immutableEnumSet(DIAMOND_DONATOR,
			MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);

	private static final ImmutableSet<PlayerRights> CONTRIBUTORONLY = Sets.immutableEnumSet(SAPPHIRE_DONATOR, EMERALD_DONATOR,
			RUBY_DONATOR, DIAMOND_DONATOR, SUPPORT, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> MEMBERS = Sets.immutableEnumSet(SAPPHIRE_DONATOR, EMERALD_DONATOR,
			RUBY_DONATOR, DIAMOND_DONATOR, SUPPORT, HELPER, MODERATOR, ADMINISTRATOR, ONYX_DONATOR, ZENYTE_DONATOR,TANZANITE_DONATOR, OWNER, YOUTUBER);
	private static final ImmutableSet<PlayerRights> REGULAR = Sets.immutableEnumSet(PLAYER, HELPER);
	private static final ImmutableSet<PlayerRights> NOTMEMBER = Sets.immutableEnumSet(PLAYER, SAPPHIRE_DONATOR);
	private static final ImmutableSet<PlayerRights> OWNERONLY = Sets.immutableEnumSet(OWNER);
	private static final ImmutableSet<PlayerRights> OWNERADMINONLY = Sets.immutableEnumSet(OWNER,ADMINISTRATOR);
	/*
	 * 
	 * The yell delay for the rank The amount of seconds the player with the
	 * specified rank must wait before sending another yell message.
	 */
	private int yellDelay;
	private String yellHexColorPrefix;
	private double experienceGainModifier;

	public int getYellDelay() {
		return yellDelay;
	}

	/*
	 * The player's yell message prefix. Color and shadowing.
	 */

	public String getYellPrefix() {
		return yellHexColorPrefix;
	}



	public double getExperienceGainModifier() {
		return experienceGainModifier;
	}

	public boolean isStaff() {
		return STAFF.contains(this);
	}

	public boolean isMember() {
		return MEMBERS.contains(this);
	}

	public boolean isRegularDonator() {
		return REGULARDONATORONLY.contains(this);
	}

	public boolean isSuperDonator() {
		return SUPERDONATORONLY.contains(this);
	}

	public boolean isExtremeDonator() {
		return EXTREMEDONATORONLY.contains(this);
	}

	public boolean isSponsorDonator() {
		return SPONSORDONATORONLY.contains(this);
	}

	public boolean isContributorOnly() {
		return CONTRIBUTORONLY.contains(this);
	}

	public boolean isMemberOnly() {
		return MEMBERONLY.contains(this);
	}

	public boolean isRegular() {
		return REGULAR.contains(this);
	}

	public boolean isNotMember() {
		/**
		 * @depreciated Use !isMember()
		 */
		return NOTMEMBER.contains(this);
	}

	public boolean isDeveloperOnly() {
		return OWNERONLY.contains(this);
	}

	public boolean OwnerDeveloperOnly() {
		return OWNERADMINONLY.contains(this);
	}

	/**
	 * Gets the rank for a certain id.
	 * 
	 * @param id The id (ordinal()) of the rank.
	 * @return rights.
	 */
	public static PlayerRights forId(int id) {
		for (PlayerRights rights : PlayerRights.values()) {
			if (rights.ordinal() == id) {
				return rights;
			}
		}
		return null;
	}

	public int getKeeperOfLightsBonusPoints(Player player) {
		/**
		 * Donator Rank bonusses
		 */
		if (player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT) {
			return 15;
		} else if(player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT ||player.getRights().equals(PlayerRights.YOUTUBER)) {
			return 15;
		} else if(player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
			return 12;
		} else if(player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
			return 10;
		} else if(player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
			return 7;
		} else if(player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
			return 5;
		} else if(player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT) {
			return 3;
		} else {
			return 0;
		}
	}
}
