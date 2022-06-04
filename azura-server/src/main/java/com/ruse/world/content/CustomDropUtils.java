package com.ruse.world.content;

import com.ruse.GameSettings;
import com.ruse.model.GameMode;
import com.ruse.model.Locations;
import com.ruse.model.PlayerRights;
import com.ruse.model.container.impl.Equipment;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Donation;

public class CustomDropUtils {


    /**
     * Increases Drop Rate
     *
     * @param player
     * @return
     */
    public static int drBonus(Player player, int npc) {
        int percentBoost = 0;
        if (player.getEquipment().contains(23044)) { //Tier 1 Aura
            percentBoost += 5;
        }
        if (player.getEquipment().contains(23045)) { //Tier 2 Aura
            percentBoost += 7;
        }
        if (player.getEquipment().contains(23046)) { //Tier 3 Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23047)) { //Tier 4 Aura
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23048)) { //Tier 5 Aura
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23049)) { //Tier 6 Aura
            percentBoost += 20;
        }

        if (player.getEquipment().contains(22100)) {
            percentBoost += 20;
        }

        if (player.getEquipment().contains(23092)
                || player.getEquipment().contains(23093)
                || player.getEquipment().contains(23094)) {// valor rings
            percentBoost += 10;
        }

        if(player.getLocation() == Locations.Location.SAPPHIRE_ZONE
                || player.getLocation() == Locations.Location.EMERALD_ZONE
                || player.getLocation() == Locations.Location.RUBY_ZONE
                || player.getLocation() == Locations.Location.DIAMOND_ZONE
                || player.getLocation() == Locations.Location.ZENYTE_ZONE) {
            percentBoost += 10;

        }
        // creator set:
        if (player.getEquipment().contains(23127))
            percentBoost += 4;
        if (player.getEquipment().contains(23128))
            percentBoost += 4;
        if (player.getEquipment().contains(23129))
            percentBoost += 4;
        if (player.getEquipment().contains(23130))
            percentBoost += 3;
        if (player.getEquipment().contains(23131))
            percentBoost += 3;
        if (player.getEquipment().contains(23132))
            percentBoost += 3;
        if (player.getEquipment().contains(23133))
            percentBoost += 4;
		//

        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }

        if (!player.isInsideRaids()) {

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.WOLF_PET.npcId) {
                percentBoost += 1;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GORILLA_PET.npcId) {
                percentBoost += 3;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.MARIO_PET.npcId) {
                percentBoost += 5;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DONKEY_KONG_PET.npcId) {
                percentBoost += 7;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VEGETA_PET.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YOSHI_PET.npcId) {
                percentBoost += 15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ZORBAK_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                percentBoost += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GREEN_FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RED_FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.HELLRAISER.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                percentBoost += 70;
            }
        }

        if (player.getInventory().contains(23254)) {
            percentBoost *= 1.5;
        }
        if(ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DR) {
            percentBoost *= 2;
        }
        /**
         * Donator Rank bonusses
         */
        if(player.getAmountDonated() >= Donation.ZENYTE_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 75;
        } else if(player.getAmountDonated() >= Donation.ONYX_DONATION_AMOUNT) {
            percentBoost += 45;
        } else if(player.getAmountDonated() >= Donation.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 30;
        } else if(player.getAmountDonated() >= Donation.RUBY_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if(player.getAmountDonated() >= Donation.EMERALD_DONATION_AMOUNT) {
            percentBoost += 15;
        } else if(player.getAmountDonated() >= Donation.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        }

        if (player.getInventory().contains(4440)) {
            percentBoost *= 1.5;
        }

        if (GameSettings.DOUBLEDR == true) {
            percentBoost *= 2;
        }

        if (player.getDoubleDRTimer() > 0) {
            percentBoost += 100;
        }
        if (player.getMinutesVotingDR() > 0) {
            percentBoost += 100;
        }

        if (GameSettings.DOUBLE_DROP) {
            percentBoost += 100;
        }


        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 6;
        }
        if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN || player.getGameMode() == GameMode.IRONMAN) {
            percentBoost += 10;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
            percentBoost += 15;
        }
        if (PrayerHandler.isActivated(player,PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        return percentBoost;
    }


    public static int getDoubleDropChance(Player player, int npc) {
        int percentBoost = 0;

        Equipment equipment = player.getEquipment();
        if (equipment.contains(23092)
                || equipment.contains(23093)
                || equipment.contains(23094)) {// valor rings
			percentBoost += 10;
        }

        if (npc == 8013 && System.currentTimeMillis() + 86400000 > player.lastVoteTime) {
            percentBoost =+ 100;
        }
        if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DROPS) {
            percentBoost =+ 100;
        }

        if (player.getEquipment().contains(23044)) { //Tier 1 Aura
            percentBoost += 5;
        }
        if (player.getEquipment().contains(23045)) { //Tier 2 Aura
            percentBoost += 7;
        }
        if (player.getEquipment().contains(23046)) { //Tier 3 Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23047)) { //Tier 4 Aura
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23048)) { //Tier 5 Aura
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23049)) { //Tier 6 Aura
            percentBoost += 20;
        }

        if (player.getGameMode() == GameMode.IRONMAN || player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
            percentBoost += 5;
        }
        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 3;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
			percentBoost += 7;
        }

		// creator set:
		if (player.getEquipment().contains(23127))
			percentBoost += 4;
		if (player.getEquipment().contains(23128))
			percentBoost += 4;
		if (player.getEquipment().contains(23129))
			percentBoost += 4;
		if (player.getEquipment().contains(23130))
			percentBoost += 3;
		if (player.getEquipment().contains(23131))
			percentBoost += 3;
		if (player.getEquipment().contains(23132))
			percentBoost += 3;
		if (player.getEquipment().contains(23133))
			percentBoost += 4;
		//


        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }

        if (player.getDoubleDDRTimer() > 0) {
            percentBoost += 100;
        }

        /**
         * Donator Rank bonusses
         */
        if(player.getAmountDonated() >= Donation.ZENYTE_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 25;
        } else if(player.getAmountDonated() >= Donation.ONYX_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if(player.getAmountDonated() >= Donation.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 15;
        } else if(player.getAmountDonated() >= Donation.RUBY_DONATION_AMOUNT) {
            percentBoost += 10;
        } else if(player.getAmountDonated() >= Donation.EMERALD_DONATION_AMOUNT) {
            percentBoost += 7;
        } else if(player.getAmountDonated() >= Donation.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        }


        if (PrayerHandler.isActivated(player,PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        return percentBoost;
    }


}
