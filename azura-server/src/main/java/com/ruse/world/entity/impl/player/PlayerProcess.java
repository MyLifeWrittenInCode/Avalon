package com.ruse.world.entity.impl.player;

import com.ruse.GameSettings;
import com.ruse.model.Locations;
import com.ruse.model.Locations.Location;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.model.Skill;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.content.PlayerPunishment;
import com.ruse.world.content.clan.ClanChatManager;
import com.ruse.world.content.combat.pvp.BountyHunter;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.construction.House;
import com.ruse.world.entity.impl.GroundItemManager;

public class PlayerProcess {

	/*
	 * The player (owner) of this instance
	 */
	private Player player;

	/*
	 * The loyalty tick, once this reaches 6, the player will be given loyalty
	 * points. 6 equals 3.6 seconds.
	 */
	private int loyaltyTick;

	/*
	 * The timer tick, once this reaches 2, the player's total play time will be
	 * updated. 2 equals 1.2 seconds.
	 */
	private int timerTick;

	/*
	 * Makes sure ground items are spawned on height change
	 */
	private int previousHeight;

	public PlayerProcess(Player player) {
		this.player = player;
		this.previousHeight = player.getPosition().getZ();
	}

	public void sequence() {


		/** COMBAT **/
		player.getCombatBuilder().process();

		player.getControllerManager().process();

		/** SKILLS **/
		if (player.shouldProcessFarming()) {
			player.getFarming().sequence();
		}

		/** MISC **/

		if (previousHeight != player.getPosition().getZ()) {
			GroundItemManager.handleRegionChange(player);
			previousHeight = player.getPosition().getZ();
		}

		int rank_amount = 0;
		if (player.getRights() == PlayerRights.SAPPHIRE_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 1;
		if (player.getRights() == PlayerRights.EMERALD_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 1;
		if (player.getRights() == PlayerRights.RUBY_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 2;
		if (player.getRights() == PlayerRights.DIAMOND_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 2;
		if (player.getRights() == PlayerRights.ONYX_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 3;
		if (player.getRights() == PlayerRights.ZENYTE_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 3;
		if (player.getRights() == PlayerRights.TANZANITE_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.PLATINUM_DONATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.SUPPORT && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.MODERATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.ADMINISTRATOR && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 4;
		if (player.getRights() == PlayerRights.OWNER && System.currentTimeMillis() + 86400000 > player.lastVoteTime)
			rank_amount = 8;
		if (!player.hasVotedToday)
			rank_amount = 0;
		if (!player.isInActive()) {
			if (loyaltyTick >= 6) {
				player.getPointsHandler().incrementLoyaltyPoints(1 + rank_amount);
				ClanChatManager.updateClans(player);
				PlayerPanel.refreshPanel(player);
				loyaltyTick = 0;
			}
			loyaltyTick++;
		}

		/*
		 * if(timerTick >= 1) { HANDLED BY PlayerPanel
		 * player.getPacketSender().sendString(39166,
		 * "@or2@Time played:  @yel@"+Misc.getTimePlayed((player.getTotalPlayTime() +
		 * player.getRecordedLogin().elapsed()))); timerTick = 0; }
		 */
		timerTick++;
		final Position location = player.getPosition().copy();

		BountyHunter.sequence(player);
		if (location.getX() == 2553 && location.getY() == 3717 && player.getSkillManager().getMaxLevel(Skill.SLAYER) < 98 && player.getSkillManager().getMaxLevel(Skill.SLAYER) < 79) {
			player.moveTo(GameSettings.HOME_CORDS);
			player.getPacketSender().sendMessage(
					"<shad=1>@or2@You must be 99+ Slayer to do Raids [2].");
			player.getPacketSender().sendMessage("<shad=1>@or1@You must be 80+ Invention to do Raids [2].");
			return;
		}
		if (player.getRegionInstance() != null
				&& (player.getRegionInstance().getType() == RegionInstanceType.CONSTRUCTION_HOUSE
				|| player.getRegionInstance().getType() == RegionInstanceType.CONSTRUCTION_DUNGEON)) {
			((House) player.getRegionInstance()).process();
		}
		/*
		if (player.getPrayerbook() == Prayerbook.CURSES && player.getLocation() == Location.ZOMBIE_LOBBY || player.getLocation() == Location.ZOMBIE
				|| player.getLocation() == Location.SOD || player.getLocation() == Location.SOD_LOBBY) {
			player.setPrayerbook(Prayerbook.NORMAL);
			player.getPacketSender().sendTabInterface(GameSettings.PRAYER_TAB, player.getPrayerbook().getInterfaceId());
		}*/
		if (player.getAchievements().getDailyAchievementsDate() != player.getAchievements().getTodayDate()) {
			player.getDailyTaskManager().refresh();
			player.getAchievements().setDailyTaskDate(player.getAchievements().getTodayDate());
//            Achievements.resetDailys(player);
		}
		if (player.getSeasonPassPlaytime().elapsed(60000 * 60)) {//1 hr
			int x = player.getPosition().getX();
			int y = player.getPosition().getY();
			if (player.getLocation() == Location.AFK
					|| player.getLocation() == Location.ZENYTE
					|| player.getLocation() == Location.TANZANITE_ZONE || player.getLocation() == Location.HOME_BANK) {
				player.getSeasonPassPlaytime().reset();
			} else {
				player.getSeasonPassPlaytime().reset();
				player.getSeasonPass().addExperience(1);
			}
		}

		if(PlayerPunishment.isReadyForUnban(player.getUsername())) {
			PlayerPunishment.unban(player.getUsername());
		}
		if(PlayerPunishment.isReadyForUnmute(player.getUsername())) {
			PlayerPunishment.unmute(player.getUsername());
		}
		if(PlayerPunishment.Jail.isReadyForParole(player.getUsername())) {
			player.sendMessage("You are eligible for parole! You may leave.");
			PlayerPunishment.Jail.unJail(player.getUsername());
		}
		if (player.getInterfaceId() == 42050) {
			ServerPerks.getInstance().updateInterface(player);
		}
		if (PlayerPunishment.Jail.isJailed(player.getUsername()) && !Locations.Location.inLocation(player, Location.JAIL)) {
			player.moveTo(new Position(2510, 9326));
		}

		/*if (player.afkTicks >= 500 && !player.afk) {
			player.moveTo(new Position(2658, 3987, 0));
			player.afk = true;
		}*/
	}
}
