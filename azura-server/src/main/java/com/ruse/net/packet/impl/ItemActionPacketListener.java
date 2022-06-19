package com.ruse.net.packet.impl;

import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.*;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.*;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.StarterTasks.StarterTaskData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.BoxLoot;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.casketopening.impl.SlayerCasket;
import com.ruse.world.content.cluescrolls.ClueScroll;
import com.ruse.world.content.cluescrolls.ClueScrollReward;
import com.ruse.world.content.cluescrolls.OLD_ClueScrolls;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.dialogue.impl.NephilimTokenExchange;
import com.ruse.world.content.holidayevents.easter2017;
import com.ruse.world.content.instanceMananger.InstanceData;
import com.ruse.world.content.instanceMananger.InstanceInterfaceHandler;
import com.ruse.world.content.instanceMananger.InstanceManager;
import com.ruse.world.content.instanceManangerGold.GoldInstanceInterfaceHandler;
import com.ruse.world.content.instanceManangerGold.GoldInstanceManager;
import com.ruse.world.content.minigames.impl.HallsOfValor;
import com.ruse.world.content.skill.impl.herblore.Herblore;
import com.ruse.world.content.skill.impl.herblore.ingredientsBook;
import com.ruse.world.content.skill.impl.hunter.*;
import com.ruse.world.content.skill.impl.hunter.Trap.TrapState;
import com.ruse.world.content.skill.impl.old_dungeoneering.ItemBinding;
import com.ruse.world.content.skill.impl.prayer.Prayer;
import com.ruse.world.content.skill.impl.runecrafting.RunecraftingPouches;
import com.ruse.world.content.skill.impl.runecrafting.RunecraftingPouches.RunecraftingPouch;
import com.ruse.world.content.skill.impl.slayer.SlayerDialogues;
import com.ruse.world.content.skill.impl.slayer.SlayerTasks;
import com.ruse.world.content.skill.impl.summoning.CharmingImp;
import com.ruse.world.content.skill.impl.summoning.SummoningData;
import com.ruse.world.content.skill.impl.woodcutting.BirdNests;
import com.ruse.world.content.transportation.*;
import com.ruse.world.content.upgrading.Upgradeables;
import com.ruse.world.entity.impl.player.Player;

import java.text.NumberFormat;
import java.util.Locale;

public class ItemActionPacketListener implements PacketListener {

    public static final int THIRD_ITEM_ACTION_OPCODE = 75;
    public static final int FIRST_ITEM_ACTION_OPCODE = 122;
    public static final int SECOND_ITEM_ACTION_OPCODE = 16;
    private static final String[] ROCK_CAKE = {"Oww!", "Ouch!", "Owwwy!", "I nearly broke a tooth!", "My teeth!",
            "Who would eat this?", "*grunt*", ":'("};
    public static int count = 0;

    public static boolean drinkSuperOverload(final Player player, int slot, int replacePotion) {
        if (player.getLocation() == Location.WILDERNESS || player.getLocation() == Location.DUEL_ARENA) {
            player.getPacketSender().sendMessage("You cannot use this potion here.");
            return false;
        }
        if (player.getOverloadPotionTimer() > 0 && player.getOverloadPotionTimer() < 750) {
            player.getPacketSender().sendMessage("You already have the effect of an Overload or Super/Infinity Overload potion.");
            return false;
        }
        if (player.getSkillManager().getCurrentLevel(Skill.CONSTITUTION) < 500) {
            player.getPacketSender().sendMessage("You need to have at least 500 Hitpoints to drink this potion.");
            return false;
        }
        player.performAnimation(new Animation(829));
        player.getInventory().getItems()[slot] = new Item(replacePotion, 1);
        player.getInventory().refreshItems();
        player.setOverloadPotionTimer(600);
        player.setPotionUsed("Super Ovl");
        TaskManager.submit(new SuperOverloadPotionTask(player));
        return true;
    }

    public static boolean drinkInfinityRage(final Player player, int slot, int replacePotion) {
        if (player.getLocation() == Location.WILDERNESS || player.getLocation() == Location.DUEL_ARENA) {
            player.getPacketSender().sendMessage("You cannot use this potion here.");
            return false;
        }
        if (player.getOverloadPotionTimer() > 0 && player.getOverloadPotionTimer() < 750) {
            player.getPacketSender().sendMessage("You already have the effect of an Overload or Super/Infinity Overload potion.");
            return false;
        }
        if (player.getSkillManager().getCurrentLevel(Skill.CONSTITUTION) < 500) {
            player.getPacketSender().sendMessage("You need to have at least 500 Hitpoints to drink this potion.");
            return false;
        }
        player.performAnimation(new Animation(829));
        player.getInventory().getItems()[slot] = new Item(replacePotion, 1);
        player.getInventory().refreshItems();
        player.setOverloadPotionTimer(600);
        player.setPotionUsed("Rage Mode");
        TaskManager.submit(new InfinityRagePotionTask(player));
        return true;
    }

    public static boolean drinkOwnerPot(final Player player, int slot, int replacePotion) {
        if (player.getLocation() == Location.WILDERNESS || player.getLocation() == Location.DUEL_ARENA) {
            player.getPacketSender().sendMessage("You cannot use this potion here.");
            return false;
        }
        if (player.getOverloadPotionTimer() > 0 && player.getOverloadPotionTimer() < 750) {
            player.getPacketSender().sendMessage("You already have the effect of an Overload or Rage/Infinity Overload potion.");
            return false;
        }
        if (player.getSkillManager().getCurrentLevel(Skill.CONSTITUTION) < 500) {
            player.getPacketSender().sendMessage("You need to have at least 500 Hitpoints to drink this potion.");
            return false;
        }
        player.performAnimation(new Animation(829));
        player.getInventory().getItems()[slot] = new Item(replacePotion, 1);
        player.getInventory().refreshItems();
        player.setOverloadPotionTimer(600);
        player.setPotionUsed("Owner Mode");
        TaskManager.submit(new OwnerPotionTask(player));
        return true;
    }

    private static void firstAction(final Player player, Packet packet) {
        int interfaceId = packet.readUnsignedShort();
        int slot = packet.readShort();
        int itemId = packet.readShort();
        /*
         * if(interfaceId == 38274) { Construction.handleItemClick(itemId, player);
         * return; }
         */
        if (Misc.checkForOwner()) {
            // System.out.println("Slot: " + slot + ", itemId: " + itemId + ", interface: " + interfaceId);
        }
        if (slot < 0 || slot > player.getInventory().capacity())
            return;
        if (player.getInventory().getItems()[slot].getId() != itemId)
            return;
        Item item = player.getInventory().getItems()[slot];
        player.setInteractingItem(item);
        if (!player.getControllerManager().processItemClick1(slot, item)) {
            return;
        }
        if (Prayer.isBone(itemId)) {
            Prayer.buryBone(player, itemId);
            return;
        }
        if (Consumables.isFood(player, itemId, slot))
            return;
        if (Consumables.isPotion(itemId)) {
            Consumables.handlePotion(player, itemId, slot);
            return;
        }

        if (BirdNests.isNest(itemId)) {
            BirdNests.searchNest(player, itemId);
            return;
        }
        if (Herblore.cleanHerb(player, itemId))
            return;
        if (MemberScrolls.handleScroll(player, itemId, false))
            return;
        if (Effigies.isEffigy(itemId)) {
            Effigies.handleEffigy(player, itemId);
            return;
        }
        if (ExperienceLamps.handleLamp(player, itemId)) {
            return;
        }
        if (player.aonBoxItem > 0) {
            player.sendMessage("Please choose to keep or gamble your item before doing this!");
            return;
        }
        if (player.getInventory().containsAny(11846, 11848, 11850, 11852, 11854, 11856, 14525, 19582, 11858) && !player.getInventory().containsAny(11846, 11848, 11850, 11852, 11854, 11856, 14525, 19582, 11858)) {
            if (!player.getClickDelay().elapsed(250) || !player.getInventory().contains(itemId))
                return;
            if (player.busy()) {
                player.getPacketSender().sendMessage("You cannot open this right now.");
                return;
            }

            int[] items = itemId == 11858 ? new int[]{4151, 10350, 10348, 10346}
                    : itemId == 19582 ? new int[]{11235, 16054, 17193, 17339}
                    : itemId == 14525 ? new int[]{15486, 14499, 14497, 14501}
                    : itemId == 19580 ? new int[]{19308, 19311, 19314, 19317, 19320}
                    : itemId == 11860 ? new int[]{10334, 10330, 10332, 10336}
                    : itemId == 11862 ? new int[]{10342, 10338, 10340, 10344}
                    : itemId == 11848 ? new int[]{4716, 4720, 4722, 4718}
                    : itemId == 11856 ? new int[]{4753, 4757, 4759, 4755}
                    : itemId == 11850 ? new int[]{4724, 4728, 4730, 4726}
                    : itemId == 11854
                    ? new int[]{4745, 4749, 4751, 4747}
                    : itemId == 11852
                    ? new int[]{4732, 4734, 4736,
                    4738}
                    : itemId == 11846
                    ? new int[]{4708, 4712,
                    4714, 4710}
                    : new int[]{itemId};

            if (player.getInventory().getFreeSlots() < items.length) {
                player.getPacketSender().sendMessage("You do not have enough space in your inventory.");
                return;
            }
            player.getInventory().delete(itemId, 1);
            for (int i : items) {
                player.getInventory().add(i, 1);
            }
            player.getPacketSender().sendMessage("You open the set and find items inside.");
            player.getClickDelay().reset();
            return;
        }


        switch (itemId) {
            case 9719:
                player.sendMessage("You must bring this to your slayer master to cancel your task.");
                break;

            case 12855:
                player.getUpgradeInterface().openInterface(Upgradeables.UpgradeType.TIER_1);
                break;
            case 23177:
                player.getInventory().delete(23177, 1);
                player.getInventory().add(23139, 1);
                player.getInventory().add(23140, 1);
                player.getInventory().add(23141, 1);
                player.getInventory().add(23142, 1);
                player.getInventory().add(23143, 1);
                break;

            case PrayerHandler.HOLY_SCROLL_DESTRUCTION_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_DESTRUCTION_IDX)) {
                    player.setUnlockedHolyPrayer(PrayerHandler.HOLY_DESTRUCTION_IDX, true);
                player.getInventory().delete(PrayerHandler.HOLY_SCROLL_DESTRUCTION_ITEM, 1);
                player.sendMessage("You unlock the Destruction holy prayer.");
                World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                        + " has unlocked the " + "<col=ff4f4f>Destruction " + "prayer!");
                } else {
                    player.sendMessage("You have already unlocked this prayer!");
                }
                break;
            case PrayerHandler.HOLY_SCROLL_HUNTERS_EYE_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_HUNTERS_EYE_IDX)) {
                    player.setUnlockedHolyPrayer(PrayerHandler.HOLY_HUNTERS_EYE_IDX, true);
                player.getInventory().delete(PrayerHandler.HOLY_SCROLL_HUNTERS_EYE_ITEM, 1);
                player.sendMessage("You unlock the Hunter's Eye holy prayer.");
                World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                        + " has unlocked the " + "<col=ff4f4f>Hunter's Eye " + "prayer!");
        } else {
            player.sendMessage("You have already unlocked this prayer!");
        }
                break;
            case PrayerHandler.HOLY_SCROLL_FORTITUDE_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_FORTITUDE_IDX)) {
                    player.setUnlockedHolyPrayer(PrayerHandler.HOLY_FORTITUDE_IDX, true);
                player.getInventory().delete(PrayerHandler.HOLY_SCROLL_FORTITUDE_ITEM, 1);
                player.sendMessage("You unlock the Fortitude holy prayer.");
                World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                        + " has unlocked the " + "<col=ff4f4f>Fortitude " + "prayer!");
                } else {
                    player.sendMessage("You have already unlocked this prayer!");
                }
                break;
            case PrayerHandler.HOLY_SCROLL_GNOMES_GREED_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_GNOMES_GREED_IDX)) {
                    player.setUnlockedHolyPrayer(PrayerHandler.HOLY_GNOMES_GREED_IDX, true);
                player.getInventory().delete(PrayerHandler.HOLY_SCROLL_GNOMES_GREED_ITEM, 1);
                player.sendMessage("You unlock the Gnome's Greed holy prayer.");
                World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                        + " has unlocked the " + "<col=ff4f4f>Gnome's Greed " + "prayer!");
        } else {
            player.sendMessage("You have already unlocked this prayer!");
        }
                break;
            case PrayerHandler.HOLY_SCROLL_SOUL_LEECH_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_SOUL_LEECH_IDX)) {
                    player.setUnlockedHolyPrayer(PrayerHandler.HOLY_SOUL_LEECH_IDX, true);
                    player.getInventory().delete(PrayerHandler.HOLY_SCROLL_SOUL_LEECH_ITEM, 1);
                    player.sendMessage("You unlock the Coup de grace holy prayer.");
                    World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                            + " has unlocked the " + "<col=ff4f4f>Coup de grace " + "prayer!");
                } else {
                    player.sendMessage("You have already unlocked this prayer!");
                }
                break;
            case PrayerHandler.HOLY_SCROLL_FURY_SWIPE_ITEM:
                if(!player.isHolyPrayerUnlocked(PrayerHandler.HOLY_FURY_SWIPE_IDX)) {
                player.setUnlockedHolyPrayer(PrayerHandler.HOLY_FURY_SWIPE_IDX, true);
                player.getInventory().delete(PrayerHandler.HOLY_SCROLL_FURY_SWIPE_ITEM, 1);
                player.sendMessage("You unlock the Fury Swipe holy prayer.");
                World.sendMessage("<shad=15536940><img=5> " + player.getUsername()
                        + " has unlocked the " + "<col=ff4f4f>Fury Swipe " + "prayer!");
                } else {
                    player.sendMessage("You have already unlocked this prayer!");
                }
                break;

            case 2677:
                if (ClueScroll.readClue(player, ClueScroll.EASY)) {
                    player.getInventory().delete(itemId, 1);
                    ClueScrollReward reward = ClueScrollReward.getWeightedReward(ClueScroll.EASY);
                    player.getInventory().add(reward.getItemId(), Misc.getRandom(reward.getMinAmt(), reward.getMaxAmt()));

                }
                break;
            case 2831:
                if (ClueScroll.readClue(player, ClueScroll.MEDIUM)) {
                    player.getInventory().delete(itemId, 1);
                    ClueScrollReward reward = ClueScrollReward.getWeightedReward(ClueScroll.MEDIUM);
                    player.getInventory().add(reward.getItemId(), Misc.getRandom(reward.getMinAmt(), reward.getMaxAmt()));

                }
                break;
            case 2773:
                if (ClueScroll.readClue(player, ClueScroll.HARD)) {
                    player.getInventory().delete(itemId, 1);
                    ClueScrollReward reward = ClueScrollReward.getWeightedReward(ClueScroll.HARD);
                    player.getInventory().add(reward.getItemId(), Misc.getRandom(reward.getMinAmt(), reward.getMaxAmt()));
                }
                break;
            case 23002:
                player.getWheelOfFortune().open();
                break;
            case 22108:
                CurrencyPouch.checkBalance(player);
                break;
            case 745:
                if (!player.getClickDelay().elapsed(100)) {
                    player.getPacketSender().sendMessage("Please wait before doing that.");
                    break;
                }

                if (player.getInventory().getFreeSlots() >= 6) {
                    player.getInventory().add(13557, 1);
                    player.getInventory().add(10942, 1);
                    player.getInventory().add(20489, 1);
                    player.getInventory().add(15002, 1);
                    player.getInventory().add(15003, 1);
                    player.getInventory().add(15004, 1);
                    player.getPacketSender().sendMessage("Enjoy your reward!");
                    World.sendMessage("<shad=1>@yel@[<img=18>" + player.getUsername() + "<img=18>] @whi@Killed 10K @red@Valentine's Boxes@whi@ and opened his Heart crystal! Happy Valentine's day!");
                    player.getInventory().delete(745, 1);
                    break;
                } else {
                    player.getPacketSender().sendMessage("You'll need at least 6 free spaces to do that.");
                }

                player.getClickDelay().reset();
                break;
            case 13802:
                if (!player.getClickDelay().elapsed(100)) {
                    player.getPacketSender().sendMessage("Please wait before doing that.");
                    break;
                }

                if (player.getInventory().getFreeSlots() >= 8) {
                    player.getInventory().delete(13802, 1);
                    player.getInventory().add(10942, 1);
                    player.getInventory().add(20489, 1);
                    player.getInventory().add(15002, 1);
                    player.getInventory().add(15003, 2);
                    player.getInventory().add(19114, 10);
                    player.getInventory().add(19115, 10);
                    player.getInventory().add(19116, 10);
                    player.getInventory().add(20488, 5);
                    player.getPacketSender().sendMessage("Enjoy your reward!");
                    World.sendMessage("<shad=1>@yel@[<img=18>" + player.getUsername() + "<img=18>] @whi@Killed 10K @red@St. Patrick Leprechauns@whi@ and opened his St. Pat Box!");
                    break;
                } else {
                    player.getPacketSender().sendMessage("You'll need at least 8 free spaces to do that.");
                }

                player.getClickDelay().reset();
                break;

            case 19000:
                DialogueManager.start(player, PetUpgrading.dialogue(player));
                break;

            case 15355:
                if (player.getDoubleDRTimer() > 0) {
                    player.sendMessage("You already have a double DR scroll active.");
                    return;
                }
                player.getInventory().delete(15355, 1);
                player.setDoubleDRTimer(6000);
                TaskManager.submit(new DoubleDRTask(player));
                break;
            case 15356:
                if (player.getDoubleDDRTimer() > 0) {
                    player.sendMessage("You already have a double DDR scroll active.");
                    return;
                }
                player.getInventory().delete(15356, 1);
                player.setDoubleDDRTimer(6000);
                TaskManager.submit(new DoubleDDRTask(player));
                break;
            case 15357:
                if (player.getDoubleDMGTimer() > 0) {
                    player.sendMessage("You already have a double DMG scroll active.");
                    return;
                }
                player.getInventory().delete(15357, 1);
                player.setDoubleDMGTimer(6000);
                TaskManager.submit(new DoubleDMGTask(player));
                break;
            case 15358:
                if (player.getDoubleDRTimer() > 0) {
                    player.sendMessage("You already have a double DR scroll active.");
                    return;
                }
                player.getInventory().delete(15358, 1);
                player.setDoubleDRTimer(3000);
                TaskManager.submit(new DoubleDRTask(player));
                break;
            case 15359:
                if (player.getDoubleDMGTimer() > 0) {
                    player.sendMessage("You already have a double DMG scroll active.");
                    return;
                }
                player.getInventory().delete(15359, 1);
                player.setDoubleDMGTimer(3000);
                TaskManager.submit(new DoubleDMGTask(player));
                break;
            case 19116:
                int[] commonsuper1 = new int[] {12855, 989, 4888, 18332, 14377,13902,13899 ,11730};
                int[] uncommonsuper1 = new int[] {13922,13952,13940,13910,13946,13934,13916,13949,13937,14915,14919,14924};
                int[] raresuper1 = new int[] {16140,2021,12860,12565,12634,22077,19136,6936,14008,14009,14010,455};
                player.getMysteryBoxOpener().display(19116, "Super Box", commonsuper1, uncommonsuper1, raresuper1);
                break;

            case 19115:
                int[] commonextreme = new int[] { 15442, 15443, 15444, 18351, 18349, 18353, 6500, 13740 };
                int[] uncommonsuper11 = new int[] {20535,19136,6936,666,15424,674};
                int[] raresuper11extreme = new int[] {8800, 8803, 8806, 8801, 8804, 8807, 8802, 8805, 8808,20549,20173,8809,10946,};
                player.getMysteryBoxOpener().display(19115, "Extreme Box", commonextreme, uncommonsuper11, raresuper11extreme);
                break;

            case 19114:// grandmbox
                int[] commongrand = new int[] { 13740, 15290};
                int[] uncommongrand = new int[] {20549, 20173, 8809,8834,8835,8860,8861,8862,15830,3318,15418};
                int[] raresgrand = new int[] {8326, 8330, 8323, 8327, 8331, 8324, 8328, 8332, 8325,22084,22083,22092,10946};
                player.getMysteryBoxOpener().display(19114, "Grand Box", commongrand, uncommongrand, raresgrand);
                break;
            case 20488:// grandmbox
                int[] commonOP = new int[] {8800, 8803, 8806, 8801, 8804, 8807, 8802, 8805, 8808,20549,20173,8809};
                int[] uncommonOP = new int[] {10946,10946,8326, 8330, 8323, 8327, 8331, 8324, 8328, 8332, 8325,22084,22083,22092 };
                int[] raresOP = new int[] {6769,10942,18753,18749,18631,18752,18748,18637,18751,18638,18623,18750,18636,18629,19886,4446 };
                player.getMysteryBoxOpener().display(20488, "OP Chest", commonOP, uncommonOP, raresOP);
                break;

            case 23257:
                DialogueManager.start(player, NephilimTokenExchange.getDialogue(player));
                break;
            case 20489:
                int[] commonLaunch = new int[] {8800, 8803, 8806, 8801, 8804, 8807, 8802, 8805, 8808, 20549, 20173, 8809,
                        10946, 6769,15290};
                int[] uncommonLaunch = new int[] {8326, 8330, 8323, 8327, 8331, 8324, 8328, 8332, 8325, 22084, 22083, 22092,
                        10942,15289};
                int[] raresLaunch = new int[] {18753, 18749, 18631, 18752, 18748, 18637, 18751, 18638, 18623, 18750, 18636,
                        18629, 4446, 19886, 10934,15288};
                player.getMysteryBoxOpener().display(20489, "Launch Casket", commonLaunch, uncommonLaunch, raresLaunch);
                break;
            case 15003:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.EMERALD_CASKET);
                player.getCasketOpening().openInterface();
                break;
            case 15002:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.RUBY_CASKET);
                player.getCasketOpening().openInterface();
                break;
            case 15004:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.DIAMOND_CASKET);
                player.getCasketOpening().openInterface();
                break;
            case 14999:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.ONYX_CASKET);
                player.getCasketOpening().openInterface();
                break;
            case 23253:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.ZENYTE_CASKET);
                player.getCasketOpening().openInterface();
                break;

            case 18404:
                player.getCasketOpening().setCurrentCasket(CasketOpening.Caskets.RAIDS);
                player.getCasketOpening().openInterface();
                break;

            case 13066:
                player.getPacketSender().sendMessage("");
                player.getPacketSender().sendMessage("You open the casket..");
                player.getInventory().add(6199,4);
                player.getInventory().add(995,50_000_000);
                player.getInventory().delete(13066, 1);
                player.getPacketSender().sendMessage("The casket contained 50M Gold Coins and some mystery boxes!");
                break;

            case 23086:
                HallsOfValor.handleReward(player);
                break;
            case 11858:
            case 11860:
            case 11862:
            case 11848:
            case 11856:
            case 11850:
            case 11854:
            case 11852:
            case 14525:
            case 19580:
            case 19582:
                if (!player.getClickDelay().elapsed(250) || !player.getInventory().contains(itemId))
                    return;
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You cannot open this right now.");
                    return;
                }

                int[] items = itemId == 11858 ? new int[]{4151, 10350, 10348, 10346}
                        : itemId == 19582 ? new int[]{11235, 16054, 17193, 17339}
                        : itemId == 14525 ? new int[]{15486, 14499, 14497, 14501}
                        : itemId == 19580 ? new int[]{19308, 19311, 19314, 19317, 19320}
                        : itemId == 11860 ? new int[]{10334, 10330, 10332, 10336}
                        : itemId == 11862 ? new int[]{10342, 10338, 10340, 10344}
                        : itemId == 11848 ? new int[]{4716, 4720, 4722, 4718}
                        : itemId == 11856 ? new int[]{4753, 4757, 4759, 4755}
                        : itemId == 11850 ? new int[]{4724, 4728, 4730, 4726}
                        : itemId == 11854
                        ? new int[]{4745, 4749, 4751, 4747}
                        : itemId == 11852
                        ? new int[]{4732, 4734, 4736,
                        4738}
                        : itemId == 11846
                        ? new int[]{4708, 4712,
                        4714, 4710}
                        : new int[]{itemId};

                if (player.getInventory().getFreeSlots() < items.length) {
                    player.getPacketSender().sendMessage("You do not have enough space in your inventory.");
                    return;
                }
                player.getInventory().delete(itemId, 1);
                for (int i : items) {
                    player.getInventory().add(i, 1);
                }
                player.getPacketSender().sendMessage("You open the set and find items inside.");
                player.getClickDelay().reset();
                break;

            case 15328:
                if (!drinkInfinityRage(player, slot, 15328))
                    return;
                player.getPacketSender().sendInterfaceRemoval();
                player.getCombatBuilder().incrementAttackTimer(1).cooldown(false);
                player.getCombatBuilder().setDistanceSession(null);
                player.setCastSpell(null);
                player.getFoodTimer().reset();
                player.getPotionTimer().reset();
                player.setOverloadPotionTimer(100000);
                if (player.getOverloadPotionTimer() > 0) { // Prevents decreasing stats
                    Consumables.overloadIncrease(player, Skill.ATTACK, 0.67);
                    Consumables.overloadIncrease(player, Skill.STRENGTH, 0.67);
                    Consumables.overloadIncrease(player, Skill.DEFENCE, 0.67);
                    Consumables.overloadIncrease(player, Skill.RANGED, 0.67);
                    Consumables.overloadIncrease(player, Skill.MAGIC, 0.67);
                }
                Sounds.sendSound(player, Sound.DRINK_POTION);
                break;

            case 15330:
                if (!drinkSuperOverload(player, slot, 15330))

                    return;
                player.getPacketSender().sendInterfaceRemoval();
                player.getCombatBuilder().incrementAttackTimer(1).cooldown(false);
                player.getCombatBuilder().setDistanceSession(null);
                player.setCastSpell(null);
                player.getFoodTimer().reset();
                player.getPotionTimer().reset();
                player.setOverloadPotionTimer(100000);
                if (player.getOverloadPotionTimer() > 0) { // Prevents decreasing stats
                    Consumables.overloadIncrease(player, Skill.ATTACK, 0.38);
                    Consumables.overloadIncrease(player, Skill.STRENGTH, 0.38);
                    Consumables.overloadIncrease(player, Skill.DEFENCE, 0.38);
                    Consumables.overloadIncrease(player, Skill.RANGED, 0.38);
                    Consumables.overloadIncrease(player, Skill.MAGIC, 0.38);
                }
                Sounds.sendSound(player, Sound.DRINK_POTION);
                break;

            case 23225:
                if (!drinkInfinityRage(player, slot, 23225))
                    return;

                player.getPacketSender().sendInterfaceRemoval();
                player.getCombatBuilder().incrementAttackTimer(1).cooldown(false);
                player.getCombatBuilder().setDistanceSession(null);
                player.setCastSpell(null);
                player.getFoodTimer().reset();
                player.getPotionTimer().reset();
                player.setOverloadPotionTimer(100000);
                if (player.getOverloadPotionTimer() > 0) { // Prevents decreasing stats
                    player.getSkillManager().setCurrentLevel(Skill.PRAYER, 200);
                    player.getSkillManager().setCurrentLevel(Skill.ATTACK, 200);
                    player.getSkillManager().setCurrentLevel(Skill.STRENGTH, 200);
                    player.getSkillManager().setCurrentLevel(Skill.DEFENCE, 200);
                    player.getSkillManager().setCurrentLevel(Skill.RANGED, 200);
                    player.getSkillManager().setCurrentLevel(Skill.MAGIC, 200);
                    player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, 1200);
                }
                Sounds.sendSound(player, Sound.DRINK_POTION);
                break;

            case 23242:
                if (!drinkOwnerPot(player, slot, 23242))
                    return;
                player.getPacketSender().sendInterfaceRemoval();
                player.getCombatBuilder().incrementAttackTimer(1).cooldown(false);
                player.getCombatBuilder().setDistanceSession(null);
                player.setCastSpell(null);
                player.getFoodTimer().reset();
                player.getPotionTimer().reset();
                player.setOverloadPotionTimer(100000);
                if (player.getOverloadPotionTimer() > 0) { // Prevents decreasing stats
                    player.getSkillManager().setCurrentLevel(Skill.PRAYER, 240);
                    player.getSkillManager().setCurrentLevel(Skill.ATTACK, 240);
                    player.getSkillManager().setCurrentLevel(Skill.STRENGTH, 240);
                    player.getSkillManager().setCurrentLevel(Skill.DEFENCE, 240);
                    player.getSkillManager().setCurrentLevel(Skill.RANGED, 240);
                    player.getSkillManager().setCurrentLevel(Skill.MAGIC, 240);
                    player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, 2400);
                }
                Sounds.sendSound(player, Sound.DRINK_POTION);
                break;

            case 21218:
                player.getInventory().delete(21218, 1);
                int num1 = 60000 / Difficulty.getDifficultyModifier(player, Skill.INVENTION);
                player.getSkillManager().addExperience(Skill.INVENTION, num1);
                player.getPacketSender().sendMessage("You've Been rewarded with some Invention XP.");
                break;

            case 21219:
                player.getInventory().delete(21219, 1);
                int num = 90000 / Difficulty.getDifficultyModifier(player, Skill.SLAYER);
                player.getSkillManager().addExperience(Skill.SLAYER, num);
                player.getPacketSender().sendMessage("You've Been rewarded with some slayer XP.");
                break;

            case 15290:
                player.getInventory().delete(15290, 1).add(ItemDefinition.UPGRADE_TOKEN_ID, 5000);
                break;

            case 19001:
                player.getInventory().delete(19001, 1).add(19000, 250);
                break;

            case 15289:
                player.getInventory().delete(15289, 1).add(ItemDefinition.UPGRADE_TOKEN_ID, 25000);
                break;

            case 15288:
                player.getInventory().delete(15288, 1).add(ItemDefinition.UPGRADE_TOKEN_ID, 100000);
                break;

            case 21221:
                player.getInventory().delete(21221, 1).add(ItemDefinition.UPGRADE_TOKEN_ID, 100 + Misc.getRandom(500));
                break;

            case 21222:
                player.getInventory().delete(21222, 1).add(ItemDefinition.UPGRADE_TOKEN_ID, 500 +  Misc.getRandom(2500));
                break;

            case 14822:
                player.getPacketSender().sendMessage("You are now licenced with VIP slayer");
                player.getPacketSender().sendMessage("Here is your Slayer pass to our exclusive VIP SLAYER ZONE.");
                player.getInventory().delete(14822, 1);
                player.getInventory().add(27, 1);
                break;

            case 27:
                player.getSlayer().handleSlayerRingTP(itemId);
                break;

            case 14819:
                if (player.getSlayer().doubleSlayerXP) {
                    player.getPacketSender().sendMessage("You already have Double Slayer Points.");
                    return;
                }
                player.getInventory().delete(14819, 1);
                player.getSlayer().doubleSlayerXP = true;
                PlayerPanel.refreshPanel(player);
                player.getPacketSender().sendMessage("You will now permanently receive double Slayer experience.");
                break;

            case 19775:
                player.getPointsHandler().incrementGlobalRate(5);
                player.sendMessage("Your Event rate is now: " + player.getPointsHandler().getGlobalRate() + " / 100%");
                player.getInventory().delete(19775, 1);
                player.getInventory().add(8212, 50);
                player.sendMessage("you were rewarded free shards");
                break;

            case 19768:
                player.getPointsHandler().incrementGlobalRate(10);
                player.getInventory().add(8212, 100);
                player.sendMessage("Your Event rate is now: " + player.getPointsHandler().getGlobalRate() + " / 100%");
                player.sendMessage("you were rewarded free shards");
                player.getInventory().delete(19768, 1);
                break;

            case 7956:
                int[] commonpvm = new int[] {10350, 10348, 4718, 10346, 14499, 14497, 14501, 4710, 16054, 17193, 17339, 4734, 4753, 4757, 4759, 4755,
                        4745, 4749, 4751, 4747, 290};
                int[] uncommonpvm = new int[] {19582, 14525, 11858, 23020};
                int[] rarepvm = new int[] {4151,11235,15486,12933,18353,15031,6585,6737,7462};
                player.getMysteryBoxOpener().display(7956, "Pvm box", commonpvm, uncommonpvm, rarepvm);
                break;

            case 10025:
                int[] commonpro = new int[] {671, 4411, 14415,14395,14405,672,673,//link
                        677,678,679,22075,19471,19470,19469,//warriors
                        666,15424,674,22078,4369,15877,16269,15943,//cthulu demon
                        675,702,700,701,17708,//master chief
                        5095,19140,19139,19138,//cosmos
                        15922,16021,15933,//king
                        17600,19944,703,704,705,19946,19946,//avatar
                };
                int[] uncommonpro = new int[] {
                        17714,17686,15924,16023,15935,15888,15818,12994,16272,8809,8806,8807,8808,//lucien
                        12284,15005,15006,15007,15008,15100,15200,15201,20549,8800,8801,8802,//hercules
                        17712,17638,17640,15593,16140,2021,12860,12565,20173,8803,8804,8805,8812,//angel
                };
                int[] rarepro = new int[] {20542,13300,13301,13304,18683,15511,13306,18817,13302,13305,//satan
                        15230,15231,15232,15233,15234,17662,15235,15236,21031,21032,21033,21034,21035, //zeus
                        13640,15448,21934,19918,19913,13964,3107,15401
                };

                player.getMysteryBoxOpener().display(10025, "Progressive Box", commonpro, uncommonpro, rarepro);
                break;
            case 455:
                player.getScratchCard().open();
                break;
            case 22215:
                int amount3 = player.getInventory().getAmount(itemId);
                player.getInventory().delete(22215, amount3).add(5022, 5_000 * amount3);
                break;

            case 22219:
                int amount4 = player.getInventory().getAmount(itemId);
                player.getInventory().delete(22219, amount4).add(5022, 10_000 * amount4);
                break;
            case 22214: //Pvm box t2
                int[] pvmcommon = new int[] {19582,14525,11858 };
                int[] pvmuncommon = new int[] {4151,11235,15486,12933,18353,15031,6585,6737,7462 };
                int[] pvmrare = new int[] {18686,18799,5095,13996,18834,19140,13913,18801,19139,13919,18800,19138 };
                player.getMysteryBoxOpener().display(22214, "PVM Box (t2)", pvmcommon, pvmuncommon, pvmrare);
                break;
            case 7120:// slayer box
                int[] commonSlayer = new int[] {671, 4411,14415,14395,14405,672,673,22075,677,678,679,19471,19470,19469,666,15424,674,22078,4369,15877,16269,15943,675,700,702,701,17708,5095,19140,19139,19138,15922,16021,15933,17600,19944};
                int[] uncommonSlayer = new int[] {17714,17686,15924,16023,15935,15888,15818,12994,16272,8809,8806,8807,8808,12284,15005,15006,15007,15008,15100,15200,15201,20549,8800,8801,8802,17712,17638,17640,15593,16140,2021,12860,12565,20173,8803,8804,8805,8812 };
                int[] rareSlayer = new int[] {20542,13300,13301,13304,18683,15511,13306,18817,13302,13305,15230,15231,15232,15233,15234,17662,15235,15236,21031,21032,21033,21034,21035,13640,15448,21934,19918,19913,13964,3107,15401 };
                player.getMysteryBoxOpener().display(7120, "Slayer Box", commonSlayer, uncommonSlayer, rareSlayer);
                break;
            case 22123:// slayer box
                int[] commonSlayerU = new int[] {15289,19114,19115,19116,22003};
                int[] uncommonSlayerU = new int[] {15288,15358,15359,8323,8324,8325,8326,8327,8328,8330,8331,8332,22092,22084,22083};
                int[] rareSlayerU = new int[] {18750,18753,18752,18751,18636,18749,18748,18638,18629,18631,18637,18623,19886,4446,10946,1486,10947,3737,3738,3739};
                player.getMysteryBoxOpener().display(22123, "Slayer Box (u)", commonSlayerU, uncommonSlayerU, rareSlayerU);
                break;
            case 21220:
                int amount5 = player.getInventory().getAmount(itemId);
                player.getInventory().delete(21220, amount5).add(5022, 1_000 * amount5);
                break;
            case 22121:
                if (player.getLocation() != Location.HOME_BANK) {
                    player.sendMessage("<shad=1>@red@You have to be in ::home to scratch this card!");
                    player.sendMessage("<shad=1>@red@You have to be in ::home to scratch this card!");
                    return;
                }
                player.getScratchcard().open();
                player.getInventory().delete(22121, 1);
                break;

            case 4278:
                if (player.getLocation() == Location.JAIL) {
                    player.sendMessage("<shad=1>@red@You can't start an instance while your in jail.");
                    return;
                }
                if (player.currentInstanceAmount >= 1) {
                    player.sendMessage("<shad=1>@red@You can't start a new instance until this one ends");
                    return;
                }
                new InstanceInterfaceHandler(player).open();
                break;
            case 23264:
                if (player.getLocation() == Location.JAIL) {
                    player.sendMessage("<shad=1>@red@You can't start an instance while your in jail.");
                    return;
                }
                if (player.currentInstanceAmount >= 1) {
                    player.sendMessage("<shad=1>@red@You can't start a new instance until this one ends");
                    return;
                }
                new GoldInstanceInterfaceHandler(player).open();
                break;
            case 2150:
                player.getInventory().delete(2150, 1);
                player.getInventory().add(2152, 1);
                player.getPacketSender().sendMessage("You remove the Toad's legs.");
                break;

            case 16:
                player.getInventory().delete(16, 1);
                Position position3 = new Position(2907, 3289, 0);
                TeleportHandler.teleportPlayer(player, position3, TeleportType.NORMAL);
                player.getPacketSender().sendMessage("You Blew on the whistle and the King summons you!");
                break;

            case 6833:
                player.getGoodieBag().boxId = itemId;
                player.getGoodieBag().rewards = new int[]{455, 6199, 19116, 10946, 15290, 16045, 15785, 19331,
                        18686, 15501, 989, 962, 3318, 3907, 11137, 4151, 12790, 15332, 7956};
                player.getGoodieBag().open();
                break;

            case 23274:
                player.getGoodieBag().boxId = itemId;
                player.getGoodieBag().rewards = new int[]{23275, 14999, 23002, 10943,15004,12630,10942,9084,22121,9083
                        ,20591,23253,10934,10935,22121,15002,7995,3578,23240,10934
                };
                player.getGoodieBag().open();
                break;

            case 3578:
                player.getGoodieBag().boxId = itemId;
                player.getGoodieBag().rewards = new int[]{10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 7995, 10934};
                player.getGoodieBag().open();
                break;

            case 23240:
                player.getGoodieBag().boxId = itemId;
                player.getGoodieBag().rewards = new int[]{10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 10934, 15004, 15003, 15002, 23232, 23231, 7995, 23230};
                player.getGoodieBag().open();
                break;


            case 7510:
                int plc = player.getConstitution();
                int plcr = 50;

                if (plc <= 50) {
                    plcr = plc - 1;
                }
                if (plc == 1) {
                    plcr = 0;
                }

                if (plcr > 0) {
                    player.performAnimation(new Animation(829));
                    Hit h = new Hit(plcr);
                    player.dealDamage(h);
                    player.forceChat(Misc.randomElement(ROCK_CAKE));
                } else {
                    player.getPacketSender().sendMessage("You'll die if you keep eating this putrid rock!");
                }
                break;

            case 22051:
                if (!player.busy()) {
                    easter2017.openInterface(player);
                } else {
                    player.getPacketSender().sendMessage("You're too busy to do that!");
                }
                break;

            case 9003:
                player.getPacketSender().sendMessage(
                        "<img=5> \"Use\" this Tome on any NPC, then select \"View-drops\" to see it's entire drop table.");
                break;
            case 2946:
                if (!player.getClickDelay().elapsed(1000)) {
                    player.getPacketSender().sendMessage("Please wait 1 second before doing that.");
                    return;
                }
                if (player.getInventory().getFreeSlots() < 4) {
                    player.getPacketSender().sendMessage("You should have at least 4 inventory spaces free.");
                    return;
                }
                player.getInventory().delete(2946, 1);
                player.getInventory().add(7329, 1);
                player.getInventory().add(7330, 1);
                player.getInventory().add(7331, 1);
                player.getInventory().add(10326, 1);
                player.getInventory().add(10327, 1);
                player.getPacketSender().sendMessage("<shad=0>@red@Enjoy your firelighters!");
                player.getClickDelay().reset();
                break;

            case 15367:
                if (!player.getClickDelay().elapsed(1000)) {
                    player.getPacketSender().sendMessage("Please wait 1 second before doing that.");
                    return;
                }
                if (player.getInventory().getFreeSlots() < 11) {
                    player.getPacketSender().sendMessage("You should have at least 11 inventory spaces free.");
                    return;
                }

                player.getInventory().delete(15367, 1);
                player.getInventory().add(2396, 1);
                player.getInventory().add(10593, 1);
                player.getInventory().add(2862, 1);
                player.getInventory().add(19963, 1);
                player.getInventory().add(6851, 5);
                player.getInventory().add(6847, 5);
                player.getInventory().add(6850, 5);
                player.getInventory().add(6849, 5);
                player.getInventory().add(8212, 300);
                player.getInventory().add(8213, 50);
                player.getPacketSender().sendMessage("<shad=0>@red@Enjoy your Christmas pack!");
                World.sendMessage("<img=17>@blu@[Christmas Pack]<img=17>@red@ " + player.getUsername()
                        + " Has just opened a Christmas ingredient pack! ");
                player.getClickDelay().reset();
                break;

            case 3904:
                if (!player.getClickDelay().elapsed(1000)) {
                    player.getPacketSender().sendMessage("Please wait 1 second before doing that.");
                    return;
                }
                if (player.getInventory().getFreeSlots() < 6) {
                    player.getPacketSender().sendMessage("You should have at least 6 inventory spaces free.");
                    return;
                }

                player.getInventory().delete(3904, 1);
                player.getInventory().add(20054, 1);
                player.getInventory().add(20061, 1);
                player.getInventory().add(18365, 1);
                player.getInventory().add(16879, 1);
                player.getInventory().add(13641, 1);
                player.getInventory().add(6199, 1);

                player.getPacketSender().sendMessage("You have claimed your starter gear!");
                player.getClickDelay().reset();
                break;
            case 20061:
                if (!player.getClickDelay().elapsed(5000)) {
                    player.getPacketSender().sendMessage("Please wait 5 seconds before doing that.");
                    return;
                }
                if (player.getInventory().getFreeSlots() < 3) {
                    player.getPacketSender().sendMessage("You should have at least 3 inventory spaces free.");
                    return;
                }

                player.getInventory().add(23020, 1);
                player.getInventory().add(290, 1);
                player.getInventory().add(6198, 1);
                player.getInventory().delete(20061, 1);
                player.getPacketSender().sendMessage("@red@Enjoy a free voting scroll - ::vote for more.");

                player.getClickDelay().reset();
                break;

          /*  case 1561:

                // player.getPacketSender().sendMessage("hi");
                if (!player.getClickDelay().elapsed(10000)) {
                    player.getPacketSender().sendMessage("Please wait 10 seconds before doing that.");
                    return;
                }
                player.getInventory().delete(1561, 1);
                int invSpace = player.getInventory().getFreeSlots();
                int daCount = 0;
                for (int i = 0; i < BossPet.values().length; i++) {
                    // // System.out.println("daCount < invSpace "+(boolean) (daCount < invSpace));
                    // // System.out.println("getBossPet("+i+"),
                    // "+ItemDefinition.forId(BossPet.values()[i].itemId).getName()+" =
                    // "+player.getBossPet(i));
                    if (daCount < invSpace && player.getBossPet(i)) {
                        player.getInventory().add(BossPet.values()[i].itemId, 1);
                        player.getPacketSender().sendMessage("Returned your "
                                + ItemDefinition.forId(BossPet.values()[i].itemId).getName() + " to your inventory.");
                        daCount++;
                    } else if (daCount >= invSpace && player.getBossPet(i) && !player.getBank(0).isFull()) {
                        player.getBank(0).add(BossPet.values()[i].itemId, 1);
                        player.getPacketSender().sendMessage("Returned your "
                                + ItemDefinition.forId(BossPet.values()[i].itemId).getName() + " to your bank.");
                        daCount++;
                    }
                }
                player.getClickDelay().reset();
                break;*/

            case 4837:
                player.getPacketSender()
                        .sendMessage("<col=0><shad=ffffff>This tomb has an unmistakable dark energy to it.");
                player.getPacketSender().sendMessage("The Devil's Notebook - by Anton LaVey, Dark Wizard.");
                break;
            case 2424:
                player.getInventory().delete(new Item(2424, 1));
                player.forceChat("It puts the lotion on it's skin...");
                player.performAnimation(new Animation(860));
                player.getInventory().add(new Item(3057, 1));
                break;
            case 8013:
            case 8012:
            case 8011:
            case 8010:
            case 8009:
            case 8008:
            case 8007:
            case 13599:
            case 13600:
            case 13601:
            case 13602:
            case 13603:
            case 13604:
            case 13605:
            case 13606:
            case 13611:
            case 13607:
            case 13608:
            case 13609:
            case 13610:
                TeleportTabs.teleportTabs(player, itemId);
                break;
            case 2724:
                OLD_ClueScrolls.openCasket(player);
                break;
            case 13663:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender().sendMessage("Please close the interface you have open before doing this.");
                    return;
                }
                player.setUsableObject(new Object[2]).setUsableObject(0, "reset");
                player.getPacketSender().sendString(38006, "Choose stat to reset!")
                        .sendMessage("@red@Please select a skill you wish to reset and then click on the 'Confim' button.")
                        .sendString(38090, "Which skill would you like to reset?");
                player.getPacketSender().sendInterface(38000);
                break;
            case 23020:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                if (!player.getInventory().contains(23020) || player.getInventory().getAmount(23020) < 1) {
                    return;
                }
                int amt = 1;
                int minutesEXP = 15 * amt;
                int minutesDR = 5 * amt;
                 int minutesDMG = 5 * amt;

                player.getInventory().delete(23020, amt);
                player.getInventory().add(ItemDefinition.UPGRADE_TOKEN_ID, 5_000 * amt);
                player.getPacketSender()
                        .sendMessage("@blu@You are rewarded " + (amt * 1) + " vote "
                                + (amt > 1 ? "points, " : "point, ") + (5_000 * amt) + " Upgrade tokens");
                player.getPacketSender()
                        .sendMessage("@blu@You received " + minutesDMG + " minutes of 100% Bonus DMG , and " + minutesDR + " minutes of 100% Bonus DR");
                player.getPointsHandler().incrementVotingPoints(amt * 1);
               // BonusExperienceTask.addBonusXp(player, minutesEXP);
                VotingDRBoostTask.addBonusDR(player, minutesDR);
                VotingDMGBoostTask.addBonusDMG(player, minutesDMG);
                StarterTasks.finishTask(player, StarterTaskData.REDEEM_A_VOTE_SCROLL);


                player.getClickDelay().reset();
                break;
            case 10138:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                VoteRewardHandler.AFKFISH(player, false);
                break;
            case 17634:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                VoteRewardHandler.AFKMINE(player, false);
                break;
            case 9013:
                String[] messages = {"BOO!", "SURPRISE!", "SPOOOKED YA", "Ooooh!", "Spoooooooookyy",
                        "ooooOOoooOOOooOOOOooo", "I'm a ghost!", "I ain't afraid of no ghost",
                        "If there's something strange in your neighborhood...", "Who you gonna call?", "GHOST BUSTERS!",// KEEP
                        // A
                        // COMMA
                        // ON
                        // THE
                        // LAST
                        // ONE!
                };
                int max = messages.length;

                // // System.out.println("Count: " + count + " | Max: " + max);
                player.forceChat(messages[count]);
                player.performAnimation(new Animation(2836));
                player.performGraphic(new Graphic(293));
                count++;

                if (count == max) {
                    // // System.out.println("Resetting count to 0");
                    count = 0;
                }
                break;
            case 20692:
                player.performGraphic(new Graphic(199));
                player.getInventory().delete(20692, 1);
                break;
            case 290:
                player.getInventory().delete(290, 1);
                int[] rewards = {200, 202, 204, 206, 208, 210, 212, 214, 216, 218, 220, 2486, 3052, 1624, 1622, 1620, 1618,
                        1632, 1516, 1514, 454, 448, 450, 452, 378, 372, 7945, 384, 390, 15271, 533, 535, 537, 18830, 556,
                        558, 555, 554, 557, 559, 564, 562, 566, 9075, 563, 561, 560, 565, 888, 890, 892, 11212, 9142, 9143,
                        9144, 9341, 9244, 866, 867, 868, 2, 10589, 10564, 6809, 4131, 15126, 4153, 1704, 1149};
                int[] rewardsAmount = {50, 50, 50, 30, 20, 30, 30, 30, 30, 20, 10, 5, 4, 70, 40, 25, 10, 10, 100, 50, 100,
                        80, 25, 25, 250, 200, 125, 50, 30, 25, 50, 20, 20, 5, 500, 500, 500, 500, 500, 500, 500, 500, 200,
                        200, 200, 200, 200, 200, 1000, 750, 200, 100, 1200, 1200, 120, 50, 20, 1000, 500, 100, 100, 1, 1, 1,
                        1, 1, 1, 1, 1};
                int rewardPos = Misc.getRandom(rewards.length - 1);
                player.getInventory().add(rewards[rewardPos],
                        (int) ((rewardsAmount[rewardPos] * 0.5) + (Misc.getRandom(rewardsAmount[rewardPos]))));
                break;
            case 15387:
                player.getInventory().delete(15387, 1);
                rewards = new int[]{1377, 1149, 7158, 3000, 219, 5016, 6293, 6889, 2205, 3051, 269, 329, 3779, 6371, 2442,
                        347, 247};
                player.getInventory().add(rewards[Misc.getRandom(rewards.length - 1)], 1);
                break;
            case 407:
                player.getInventory().delete(407, 1);
                if (Misc.getRandom(3) < 3) {
                    player.getInventory().add(409, 1);
                } else if (Misc.getRandom(4) < 4) {
                    player.getInventory().add(411, 1);
                } else
                    player.getInventory().add(413, 1);
                break;
            case 405:
                player.getInventory().delete(405, 1);
                if (Misc.getRandom(1) < 1) {
                    int coins = Misc.getRandom(30000);
                    player.getInventory().add(ItemDefinition.COIN_ID, coins);
                    player.getPacketSender().sendMessage(
                            "The casket contained " + NumberFormat.getInstance(Locale.US).format(coins) + " coins!");
                } else
                    player.getPacketSender().sendMessage("The casket was empty.");
                break;
            case 2714:
                int amount = Misc.getRandom(100000);
                player.getInventory().delete(2714, 1);
                player.getInventory().add(ItemDefinition.COIN_ID, amount);
                player.getPacketSender().sendMessage(
                        "Inside the casket you find " + NumberFormat.getInstance(Locale.US).format(amount) + " coins!");
                break;
            case 15084:
                Gambling.rollDice(player);
                break;

            case 15098:
                Gambling.ScamrollDice(player);
                break;
            case 299:
                Gambling.plantSeed(player);
                break;
            case 15103:
                player.getPacketSender().sendMessage("This came from a Goblin. Kill Nex, or Zulrah for another.");
                break;
            case 15104:
                player.getPacketSender().sendMessage("This came from Nex or Zulrah. Kill Monkey Skeletons for another.");
                break;
            case 15105:
                player.getPacketSender().sendMessage("This came from a Monkey Skeleton. Kill the KBD for another.");
                break;
            case 15106:
                player.getPacketSender().sendMessage("This came from the KBD, kill Goblins for another.");
                break;
            /*
             * player.getPacketSender().
             * sendMessage("What lies in the <shad=f999f7>Antiqua Carcere<shad=-1>?");
             * player.getPacketSender().
             * sendMessage("The <shad=b40404>Nbmfgjdvt<shad=-1> may hold next piece.");
             * player.getPacketSender().sendMessage("The..."); player.getPacketSender().
             * sendMessage("<shad=ffffff>01010101 01101110 01100111");
             * player.getPacketSender().
             * sendMessage("<shad=ffffff>01110101 01101001 01110011 ");
             * player.getPacketSender().sendMessage("holds the next piece.");
             * player.getPacketSender().sendMessage("The..."); player.getPacketSender().
             * sendMessage("<shad=000000>53 61 67 69 74 74 61 72 69 69 73");
             * player.getPacketSender().sendMessage("holds the next piece."); break;
             */
            case 4155:
                if (player.getSlayer().getSlayerTask() == SlayerTasks.NO_TASK) {
                    player.getPacketSender().sendInterfaceRemoval();
                    player.getPacketSender().sendMessage("You do not have a Slayer task.");
                    return;
                }
                DialogueManager.start(player, SlayerDialogues.dialogue(player));
                break;
            case 18719: // potion of flight
                if (player.canFly()) {
                    player.getPacketSender().sendMessage("You already know how to fly.");
                } else {
                    player.getInventory().delete(18719, 1);
                    player.getPacketSender().sendMessage("Your mind is filled with the secrets of flight!")
                            .sendMessage("Use ::fly to toggle flight on and off.");
                    player.setCanFly(true);
                    player.setFlying(true);
                    player.newStance();
                }
                break;
            case 7587:
                if (player.canGhostWalk()) {
                    player.getPacketSender().sendMessage("You already know how to ghost walk.");
                } else {
                    player.getInventory().delete(7587, 1);
                    player.getPacketSender().sendMessage("Your mind is filled with the secrets of death!")
                            .sendMessage("Use ::ghostwalk to toggle it on and off.");
                    player.setCanGhostWalk(true);
                    player.setGhostWalking(true);
                    player.newStance();
                }
                break;
            case 952:
                Digging.dig(player);
                break;
            case 11261:
            case 1748:
            case 1750:
            case 1752:
            case 1754:
            case 228:
                int[] uimint = {1748, 1750, 1752, 1754, 228};
                for (int i = 0; i < uimint.length; i++) {
                    if (uimint[i] == itemId && !player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN)) {
                        player.getPacketSender().sendMessage("Only Ultimate Ironman characters can do that.");
                        return;
                    }
                }
                if (!player.getClickDelay().elapsed(100)) {
                    return;
                }
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You're too busy to un-note that.");
                    break;
                }
                if (player.getInventory().isFull()) {
                    player.getPacketSender().sendMessage("You need a free inventory space to un-note that.");
                    break;
                }
                String orig = ItemDefinition.forId(itemId).getName(), cur = ItemDefinition.forId(itemId - 1).getName();
                if (!orig.equalsIgnoreCase(cur)) {
                    player.getPacketSender().sendMessage("Error 21641: a = " + itemId + " &-1");
                    break;
                }
                player.getClickDelay().reset();
                int b = player.getInventory().getAmount(itemId);
                player.getInventory().delete(itemId, 1);
                if (player.getInventory().getAmount(itemId) == (b - 1)) {
                    player.getInventory().add((itemId - 1), 1);
                } else {
                    player.getPacketSender()
                            .sendMessage("Error 41265: b = " + b + ", c = " + player.getInventory().getAmount(itemId));
                    break;
                }
                break;
            case 10006:
                // Hunter.getInstance().laySnare(client);
                Hunter.layTrap(player, new SnareTrap(new GameObject(19175, new Position(player.getPosition().getX(),
                        player.getPosition().getY(), player.getPosition().getZ())), TrapState.SET, 200, player));
                break;
            case 10008:
                Hunter.layTrap(player, new BoxTrap(new GameObject(19187, new Position(player.getPosition().getX(),
                        player.getPosition().getY(), player.getPosition().getZ())), TrapState.SET, 200, player));
                break;
            case 5509:
            case 5510:
            case 5512:
            case 5514:
                RunecraftingPouches.fill(player, RunecraftingPouch.forId(itemId));
                break;
            case 292:
                ingredientsBook.readBook(player, 0, false);
                break;
            case 8868:
                player.getInventory().delete(8868, 1);
                player.getInventory().add(19116, 2);
                player.getInventory().add(7956, 5);
                player.getInventory().add(989, 10);
                player.sendMessage(
                        "<shad=1>@blu@You swapped your @red@key@blu@ for @red@X5@blu@ PVM Box, @red@X10@blu@ Ckeys, @red@X2@blu@ Super Mbox");
                break;
            case 14471:
                player.getInventory().delete(14471, 1);
                player.getInventory().add(19116, 2);
                player.getInventory().add(7956, 5);
                player.getInventory().add(989, 10);
                player.sendMessage(
                        "<shad=1>@blu@You swapped your @red@key@blu@ for @red@X5@blu@ PVM Box, @red@X10@blu@ Ckeys, @red@X2@blu@ Super Mbox");
                break;
            case 9662:
                player.getInventory().delete(9662, 1);
                player.getInventory().add(19116, 2);
                player.getInventory().add(7956, 5);
                player.getInventory().add(989, 10);
                player.sendMessage(
                        "<shad=1>@blu@You swapped your @red@key@blu@ for @red@X5@blu@ PVM Box, @red@X10@blu@ Ckeys, @red@X2@blu@ Super Mbox");
                break;
            case 3468:
                player.getInventory().delete(3468, 1);
                player.getInventory().add(19116, 2);
                player.getInventory().add(7956, 5);
                player.getInventory().add(989, 10);
                player.sendMessage(
                        "<shad=1>@blu@You swapped your @red@key@blu@ for @red@X5@blu@ PVM Box, @red@X10@blu@ Ckeys, @red@X2@blu@ Super Mbox");
                break;
            case 2734:
                int amountNeeded = 4;
                if (player.getInventory().contains(995))
                    amountNeeded -= 1;
                if (player.getInventory().contains(5023))
                    amountNeeded -= 1;
                if (player.getInventory().contains(11137))
                    amountNeeded -= 1;
                if (player.getInventory().getFreeSlots() < amountNeeded) {
                    player.sendMessage("You need atleast "+amountNeeded+" inventory slots to do this.");
                    return;
                }
                player.getInventory().delete(2734, 1);
                Box loot = BoxLoot.getLoot(SlayerCasket.loot);
                player.getInventory().add(995, 10000 + Misc.getRandom(490000));
                player.getInventory().add(5023, 10 + Misc.getRandom(40));
                player.getInventory().add(11137, 1 + Misc.getRandom(2));
                player.getInventory().add(loot.getId(), loot.getMin() + Misc.getRandom(loot.getMax() - loot.getMin()));
                break;
            case 6199:
                int[] common = new int[] {12855,1149,1249,3204,1305,1215,1377,1434,7158,989,536};
                int[] uncommon = new int[] {6739, 11728, 15259, 6570,3320,3318,4888,18332,14377};
                int[] rare = new int[] {18686,18799,5095,13996,18834,19140,13913,18801,19139,13919,18800,19138,14915,14919,14924};
                player.getMysteryBoxOpener().display(6199, "Mystery Box", common, uncommon, rare);
                break;

            case 15682:
                if (!player.getInventory().contains(15682)) {
                    return;
                }
                if (!player.getClickDelay().elapsed(1000)) {
                    return;
                }
                player.getClickDelay().reset();
                player.getInventory().delete(15682, 1);
                player.getInventory().add(23020, 3);
                break;
            case 11884:
                player.getInventory().delete(11884, 1);
                player.getInventory().add(2595, 1).refreshItems();
                player.getInventory().add(2591, 1).refreshItems();
                player.getInventory().add(3473, 1).refreshItems();
                player.getInventory().add(2597, 1).refreshItems();
                break;
            case 11882:
                player.getInventory().delete(11882, 1);
                player.getInventory().add(2595, 1).refreshItems();
                player.getInventory().add(2591, 1).refreshItems();
                player.getInventory().add(2593, 1).refreshItems();
                player.getInventory().add(2597, 1).refreshItems();
                break;
            case 11906:
                player.getInventory().delete(11906, 1);
                player.getInventory().add(7394, 1).refreshItems();
                player.getInventory().add(7390, 1).refreshItems();
                player.getInventory().add(7386, 1).refreshItems();
                break;
            case 15262:
                if (!player.getClickDelay().elapsed(1000))
                    return;
                player.getInventory().delete(15262, 1);
                player.getInventory().add(18016, 10000).refreshItems();
                player.getClickDelay().reset();
                break;
            case 6:
                // DwarfMultiCannon.setupCannon(player);
                player.getPacketSender().sendMessage("Cannon is disabled.");
                break;
            case 2722:
            case 2723:
            case 2725:
            case 2727:
            case 2729:
            case 2731:
            case 2733:
            case 2735:
            case 2737:
            case 2739:
            case 2741:
            case 2743:
            case 2745:
            case 2747:
                //case 2773:
            case 2774:
            case 2776:
            case 2778:
            case 2780:
            case 2782:
            case 2783:
            case 2785:
            case 2786:
            case 2788:
            case 2790:
            case 2792:
            case 2793:
            case 2794:
            case 2796:
            case 2797:
            case 2799:
            case 3520:
            case 3522:
            case 3524:
            case 3525:
            case 3526:
            case 3528:
            case 3530:
            case 3532:
            case 3534:
            case 3536:
            case 3538:
            case 3540:
            case 3542:
            case 3544:
            case 3546:
            case 3548:
            case 3550:
                player.getInventory().delete(itemId, 1);
                OLD_ClueScrolls.awardCasket(player);
                /*for (int i = 0; i < CLUESCROLL.values().length; i++) {
                    if (CLUESCROLL.values()[i].getClueId() == itemId) {
                        int steps = player.getPointsHandler().getClueSteps();
                        String s = "steps";
                        if (steps == 1) {
                            s = "step";
                        }
                        player.getPacketSender().sendMessage(CLUESCROLL.values()[i].getHint() + " You've done "
                                + player.getPointsHandler().getClueSteps() + " " + s + ".");
                        break;
                    }
                }*/
        }
    }

    public static void thirdAction(Player player, Packet packet) {
        int interfaceId = packet.readLEShortA();
        int slot = packet.readLEShort();
        int itemId = packet.readShortA();
        if (slot < 0 || slot > player.getInventory().capacity())
            return;
        if (player.getInventory().getItems()[slot].getId() != itemId)
            return;

        player.setInteractingItem(player.getInventory().getItems()[slot]);


        if (SummoningData.isPouch(player, itemId, 2))
            return;


        if (PetUpgrading.upgradeable(player, itemId)) {
            return;
        }
        player.getDissolving().handle(itemId);
        switch (itemId) {
            case 13591:
                player.getPacketSender().sendMessage("You rub the enchanted key to teleport to chest area.");
                Position position = new Position(2706, 2737, 0);
                TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
                break;
            case 6500:
                if (player.getCombatBuilder().isAttacking() || player.getCombatBuilder().isBeingAttacked()) {
                    player.getPacketSender().sendMessage("You cannot configure this right now.");
                    return;
                }
                player.getPacketSender().sendInterfaceRemoval();
                DialogueManager.start(player, 101);
                player.setDialogueActionId(60);
                break;
            case 23071:
                if (player.getInventory().contains(23071) && player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 250000 && player.getPointsHandler().getSlayerPoints() > 250) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 250000);
                    player.getPointsHandler().setSlayerPoints(-250, true);
                    player.getInventory().delete(23071, 1);
                    player.getInventory().add(23069, 1);
                    player.sendMessage("Congratulations you have upgraded your helm to t2. ");
                } else {
                    player.sendMessage("You need 250k Tokens and 250 Slayer points to upgrade the helm to t2.");
                }
                break;
            case 23069:
                if (player.getInventory().contains(23069) && player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 500_000 && player.getPointsHandler().getSlayerPoints() > 500) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 500_000);
                    player.getPointsHandler().setSlayerPoints(-500, true);
                    player.getInventory().delete(23069, 1);
                    player.getInventory().add(23070, 1);
                    player.sendMessage("Congratulations you have upgraded your helm to t3. ");
                } else {
                    player.sendMessage("You need 500k Tokens and 500 Slayer points to upgrade the helm to t2.");
                }
                break;
            case 23070:
                if (player.getInventory().contains(23070) && player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 2_500_000 && player.getPointsHandler().getSlayerPoints() > 2500) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 2_500_000);
                    player.getPointsHandler().setSlayerPoints(-2500, true);
                    player.getInventory().delete(23070, 1);
                    player.getInventory().add(23074, 1);
                    player.sendMessage("Congratulations you have upgraded your helm to t4. ");
                } else {
                    player.sendMessage("You need 2.5m Tokens and 2500 Slayer points to upgrade the helm to t2.");
                }
                break;
            case 23074:
                if (player.getInventory().contains(23074) && player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 5_000_000 && player.getPointsHandler().getSlayerPoints() > 5000) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 5_000_000);
                    player.getPointsHandler().setSlayerPoints(-5000, true);
                    player.getInventory().delete(23074, 1);
                    player.getInventory().add(23072, 1);
                    player.sendMessage("Congratulations you have upgraded your helm to t5. ");
                } else {
                    player.sendMessage("You need 5m Tokens and 5000 Slayer points to upgrade the helm to t2.");
                }
                break;
            case 23072:
                if (player.getInventory().contains(23072) && player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 25_000_000 && player.getPointsHandler().getSlayerPoints() > 5000) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 25_000_000);
                    player.getPointsHandler().setSlayerPoints(-5000, true);
                    player.getInventory().delete(23072, 1);
                    player.getInventory().add(23073, 1);
                    player.sendMessage("Congratulations you have upgraded your helm to t6. ");
                } else {
                    player.sendMessage("You need 25m Tokens and 5000 Slayer points to upgrade the helm to t2.");
                }
                break;

            case 1712: // glory start
            case 1710:
            case 1708:
            case 1706: // glory end
            case 11118: // cb brace start
            case 11120:
            case 11122:
            case 11124: // cb brace end
            case 2552: // duel start
            case 2554:
            case 2556:
            case 2558:
            case 2560:
            case 2562:
            case 2564:
            case 2566: // duel end
            case 3853: // games start
            case 3855:
            case 3857:
            case 3859:
            case 3861:
            case 3863:
            case 3865:
            case 3867: // games end
            case 11194: // digsite start
            case 11193:
            case 11192:
            case 11191:
            case 11190: // digsite start
                Position position1 = new Position(2074, 4456, 0);
                TeleportHandler.teleportPlayer(player, position1, TeleportType.NORMAL);
                break;
            case 10362:
                JewelryTeleporting.rub(player, itemId);
                break;
            case 10732:
            case 4566:
                player.performAnimation(new Animation(1835));
                break;

            case 11113:
                player.getPacketSender().sendMessage("All skill teleports are available in the skills tab.");
                break;

            case 1704:
                player.getPacketSender().sendMessage("Your amulet has run out of charges.");
                break;
            case 11126:
                player.getPacketSender().sendMessage("Your bracelet has run out of charges.");
                break;
            case 13281:
            case 13282:
            case 13283:
            case 13284:
            case 13285:
            case 13286:
            case 13287:
            case 13288:

                player.getSlayer().handleSlayerRingTP(itemId);
                break;
            case 18819:
                player.getSlayer().handleSlayerRingTP2(itemId);
                break;
            case 5509:
            case 5510:
            case 5512:
            case 5514:
                RunecraftingPouches.check(player, RunecraftingPouch.forId(itemId));
                break;
            case 2550:
                if (!player.getInventory().contains(2550)) {
                    player.getPacketSender().sendMessage("You must have a ring of recoil in your inventory to do this.");
                    return;
                }
                if (ItemDegrading.maxRecoilCharges - player.getRecoilCharges() == ItemDegrading.maxRecoilCharges) {
                    player.getPacketSender().sendMessage("You already have the maximum ring of recoil charges.");
                    return;
                }
                player.getInventory().delete(2550, 1);
                player.setRecoilCharges(0);
                player.getPacketSender().sendMessage("Your ring of recoil turns to dust, and your charges are reset.");
                break;

            case 12926:
                int charges = player.getBlowpipeCharges();
                if (!player.getInventory().contains(12926)) {
                    return;
                }
                if (charges <= 0) {
                    player.getPacketSender().sendMessage("You have no charges!");
                    return;
                }
                if (player.getInventory().contains(12934) || !player.getInventory().isFull()) {
                    player.getInventory().add(12934, charges);
                    player.setBlowpipeCharges(0);
                    player.getPacketSender().sendMessage(
                            "You uncharge your blowpipe and recieve " + Misc.format(charges) + " Zulrah scales");
                } else {
                    player.getPacketSender().sendMessage("You need an inventory space.");
                }
                break;
            case ItemDefinition.COIN_ID:
                ConvertCoins.convertMillCoins(player);
                break;
            case 19131:
                if (player.getInventory().contains(19131) && player.getInventory().getAmount(12657) >= 1000) {
                    player.getInventory().delete(19131, 1).delete(12657, 1000).add(19130, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 1000 Pebbles to upgrade your boots.");
                }
                break;
            case 19130:
                if (player.getInventory().contains(19130) && player.getInventory().getAmount(12657) >= 2000) {
                    player.getInventory().delete(19130, 1).delete(12657, 2000).add(19129, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 2000 Pebbles to upgrade your boots.");
                }
                break;
            case 19129:
                if (player.getInventory().contains(19129) && player.getInventory().getAmount(12657) >= 3000) {
                    player.getInventory().delete(19129, 1).delete(12657, 3000).add(19128, 1);
                    player.getPacketSender().sendMessage("You have upgraded your Steel boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 3000 Pebbles to upgrade your boots.");
                }
                break;
            case 19128:
                if (player.getInventory().contains(19128) && player.getInventory().getAmount(12657) >= 4000) {
                    player.getInventory().delete(19128, 1).delete(12657, 4000).add(19127, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 4000 Pebbles to upgrade your boots.");
                }
                break;
            case 19127:
                if (player.getInventory().contains(19127) && player.getInventory().getAmount(12657) >= 5000) {
                    player.getInventory().delete(19127, 1).delete(12657, 5000).add(19126, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 5000 Pebbles to upgrade your boots.");
                }
                break;
            case 19126:
                if (player.getInventory().contains(19126) && player.getInventory().getAmount(12657) >= 6000) {
                    player.getInventory().delete(19126, 1).delete(12657, 6000).add(19125, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 6000 Pebbles to upgrade your boots.");
                }
                break;
            case 19125:
                if (player.getInventory().contains(19125) && player.getInventory().getAmount(12657) >= 7000) {
                    player.getInventory().delete(19125, 1).delete(12657, 7000).add(19124, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 7000 Pebbles to upgrade your boots.");
                }
                break;
            case 19124:
                if (player.getInventory().contains(19124) && player.getInventory().getAmount(12657) >= 8000) {
                    player.getInventory().delete(19124, 1).delete(12657, 8000).add(19123, 1);
                    player.getPacketSender().sendMessage("You have upgraded your boots!");
                } else {
                    player.getPacketSender().sendMessage("You need at least 8000 Pebbles to upgrade your boots.");
                }
                break;

            /*case 1438:
            case 1448:
            case 1440:
            case 1442:
            case 1444:
            case 1446:
            case 1454:
            case 1452:
            case 1462:
            case 1458:
            case 1456:
            case 1450:
                Runecrafting.handleTalisman(player, itemId);
                break;*/
        }
    }

    public void secondAction(Player player, Packet packet) {
        int itemId = packet.readShortA();
        int slot = packet.readLEShortA();
        int interfaceId = packet.readLEShortA();
        if (slot < 0 || slot > player.getInventory().capacity())
            return;
        if (player.getInventory().getItems()[slot].getId() != itemId)
            return;
        if (JarData.forJar(itemId) != null) {
            PuroPuro.lootJar(player, new Item(itemId, 1), JarData.forJar(itemId));
            return;
        }
        if (SummoningData.isPouch(player, itemId, 3)) {
            return;
        }
        if (ItemBinding.isBindable(itemId)) {
            ItemBinding.bindItem(player, itemId);
            return;
        }


        if (MemberScrolls.handleScroll(player, itemId, true))
            return;
        player.getDissolving().handle(itemId);
        switch (itemId) {

            case 4278:
                if (player.getLocation() == Location.JAIL) {
                    player.sendMessage("<shad=1>@cya@You can't start an instance while your in jail.");
                    return;
                }

                if (player.currentInstanceAmount >= 1) {
                    player.sendMessage("<shad=1>@red@You can't start a new instance until this one ends");
                    return;
                }

                if (player.lastInstanceNpc == -1) {
                    player.sendMessage("<shad=1>@red@You need a valid last instance before doing this!");
                    return;
                }

                boolean validNpc = false;
                for (InstanceData data : InstanceData.values()) {
                    if (data.getNpcid() == player.lastInstanceNpc) {
                        validNpc = true;
                        break;
                    }
                }

                if (!validNpc) {
                    player.sendMessage("<shad=1>@red@You need a valid last instance before doing this!");
                    return;
                }

                new InstanceManager(player).create3X3Instance(player.lastInstanceNpc, RegionInstance.RegionInstanceType.INSTANCE);
                break;
            case 23264:
                if (player.getLocation() == Location.JAIL) {
                    player.sendMessage("<shad=1>@cya@You can't start an instance while your in jail.");
                    return;
                }

                if (player.currentInstanceAmount >= 1) {
                    player.sendMessage("<shad=1>@red@You can't start a new instance until this one ends");
                    return;
                }

                if (player.lastInstanceNpc == -1) {
                    player.sendMessage("<shad=1>@red@You need a valid last instance before doing this!");
                    return;
                }

                boolean valid = false;
                for (InstanceData data : InstanceData.values()) {
                    if (data.getNpcid() == player.lastInstanceNpc) {
                        valid = true;
                        break;
                    }
                }

                if (!valid) {
                    player.sendMessage("<shad=1>@red@You need a valid last instance before doing this!");
                    return;
                }

                new GoldInstanceManager(player).create3X3Instance(player.lastInstanceNpc, RegionInstance.RegionInstanceType.INSTANCE);
                break;
            case 23014:
            case 23015:
            case 23016:
            case 23017:
                if (player.getInventory().contains(itemId)) {
                    player.getInventory().delete(itemId, 1);
                    player.getInventory().add(23013, 1);
                    player.sendMessage("You reverted your mask.");
                }
                break;
           /* case 15330:
                if (player.getInventory().contains(15330) &&
                        player.getInventory().getAmount(ItemDefinition.MILL_ID) >= 50_000_000) {
                    player.getInventory().delete(ItemDefinition.MILL_ID, 50_000_000);
                    player.getInventory().delete(15330, 1);
                    player.getInventory().add(15328, 1);
                    player.sendMessage("Congratulations you have upgraded your infinite super overload to a infinity rage potion!");
                    String msg = "@blu@<img=5>[CREATION]<img=5>@red@ " + player.getUsername() + " has created an Infinity Rage potion!";
                    World.sendMessage(msg);
                } else {
                    player.sendMessage("You need 50m Avalon tokens to upgrade.");
                }
                break;*/
            case 22108:
                DialogueManager.start(player, 9924);
                player.setDialogueActionId(9924);
                break;
           /* case 19000:
                if (player.getInventory().contains(19000)) {
                    int amount = player.getInventory().getAmount(19000);
                    player.getInventory().delete(19000, amount);
                    player.getInventory().add(ItemDefinition.MILL_ID, amount * 100);
                    player.sendMessage("You have exchanged X" + amount + " Pet fragments for X" + amount * 100 + " Avalon tokens!");
                }
                break;*/

          /*  case 5021:

                int amount1 = player.getInventory().getAmount(5021);
                if (amount1 > 2147 || amount1 + player.getInventory().getAmount(ItemDefinition.COIN_ID) > 2147000000) {
                    long amountLeft;
                    if (!player.getInventory().contains(ItemDefinition.COIN_ID))
                        amountLeft = (long) (((long) amount1 * (long) 1000000) - (long) 2147000000);
                    else
                        amountLeft = ((long) amount1 * (long) 1000000) - (long) (2147000000 - player.getInventory().getAmount(ItemDefinition.COIN_ID));
                    player.getInventory().delete(5021, amount1);
                    player.getInventory().add(ItemDefinition.COIN_ID, 2147000000 - (player.getInventory().getAmount(ItemDefinition.COIN_ID)));
                    player.setMoneyInPouch(player.getMoneyInPouch() + amountLeft);
                    player.getPacketSender().sendString(8135, "" + player.getMoneyInPouch());
                    player.sendMessage("<shad=1>@red@The rest of the cash(" + amountLeft / 1000000
                            + "M) has been added to your @blu@pouch@red@!");
                    return;
                }
                player.getInventory().delete(5021, amount1);
                player.getInventory().add(ItemDefinition.COIN_ID, 1000000 * amount1);
                break;*/

            case 11846:
            case 11848:
            case 11850:
            case 11852:
            case 11854:
            case 11856:
            case 11858:
            case 19582:
            case 14525:
                if (!player.getClickDelay().elapsed(250) || !player.getInventory().contains(itemId))
                    return;
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You cannot open this right now.");
                    return;
                }
                int amountToOpen = player.getInventory().getAmount(itemId);
                if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
                    amountToOpen = player.getInventory().getFreeSlots() / 4;
                    if (amountToOpen > player.getInventory().getAmount(itemId))
                        amountToOpen = player.getInventory().getAmount(itemId);
                }
                if (amountToOpen == 0) {
                    player.getPacketSender().sendMessage("You do not have enough inventory space to do this.");
                    return;
                }

                int[] items = itemId == 11858 ? new int[]{4151, 10350, 10348, 10346}
                        : itemId == 19582 ? new int[]{11235, 16054, 17193, 17339}
                        : itemId == 14525 ? new int[]{15486, 14499, 14497, 14501}
                        : itemId == 19580 ? new int[]{19308, 19311, 19314, 19317, 19320}
                        : itemId == 11860 ? new int[]{10334, 10330, 10332, 10336}
                        : itemId == 11862 ? new int[]{10342, 10338, 10340, 10344}
                        : itemId == 11848 ? new int[]{4716, 4720, 4722, 4718}
                        : itemId == 11856 ? new int[]{4753, 4757, 4759, 4755}
                        : itemId == 11850 ? new int[]{4724, 4728, 4730, 4726}
                        : itemId == 11854 ? new int[]{4745, 4749, 4751, 4747}
                        : itemId == 11852 ? new int[]{4732, 4734, 4736, 4738}
                        : itemId == 11846 ? new int[]{4708, 4712, 4714, 4710}
                        : new int[]{itemId};

                int[][] tabs = new int[items.length][2];

                int index = 0;
                for (int z : items) {
                    tabs[index][0] = z;
                    tabs[index][1] = Bank.getTabForItem(player, z);
                    index++;
                }

                for (int i = 0; i < amountToOpen; i++) {
                    player.getInventory().delete(itemId, 1, false);

                    for (int[] z : tabs) {
                        if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
                            player.getInventory().add(new Item(z[0], 1), false);
                        } else {
                            Item item = new Item(z[0], 1);
                            if (ItemDefinition.forId(item.getId()).isNoted()) {
                                item.setId(Item.getUnNoted(item.getId()));
                            }
                            player.getBank(z[1]).add(item, false);
                            //player.depositItemBank(z[1], new Item(z[0], 1), false);
                        }
                    }
                }
                player.getClickDelay().reset();
                player.getInventory().refreshItems();
                player.getPacketSender().sendMessage("You opened " + amountToOpen + " sets.");
                break;
            case 5500:
                if (player.getPointsHandler().getSlayerRate() >= 6) {
                    player.sendMessage("You can't claim more than X6 Multipliers total!");
                    return;
                }

                player.getPointsHandler().incrementSlayerRate(1);
                player.getPacketSender().sendMessage("You have increased your slayer rate. @blu@"
                        + player.getPointsHandler().getSlayerRate() + "@bla@ is now your total multiplier.");
                PlayerPanel.refreshPanel(player);
                player.getInventory().delete(5500, 1);


                break;
            case ItemDefinition.COIN_ID:
                ConvertCoins.convertMillCoins(player);
                break;
            case ItemDefinition.MILL_ID:
                int amount = player.getInventory().getAmount(ItemDefinition.MILL_ID);
                if (amount >= 2147483)
                    amount = 2147483;

                int sum = (int) ((double) player.getInventory().getAmount(ItemDefinition.COIN_ID) + (double) (amount * 1_000));

                if (sum >= Integer.MAX_VALUE || sum <= 0)
                    amount = (int) (2147483 - Math.ceil(((double) player.getInventory().getAmount(ItemDefinition.COIN_ID) / (double) 1_000)));

                player.getInventory().delete(ItemDefinition.MILL_ID, amount);
                player.getInventory().add(ItemDefinition.COIN_ID, amount * 1_000);
                break;
            case 12845:
                player.getPointsHandler().incrementPengRate(2);
                player.getPacketSender().sendMessage("You have increased your penguin rate. @blu@"
                        + player.getPointsHandler().getPengRate() + "@bla@ is now your total multiplier.");
                PlayerPanel.refreshPanel(player);
                player.getInventory().delete(12845, 1);
                break;
            case 5154:
                player.getPointsHandler().incrementPengRate(100);
                player.getPacketSender().sendMessage("You have increased your penguin rate. @blu@"
                        + player.getPointsHandler().getPengRate() + "@bla@ is now your total multiplier.");
                PlayerPanel.refreshPanel(player);
                player.getInventory().delete(5154, 1);
                break;
            case 5155:
                player.getPointsHandler().incrementPengRate(1000);
                player.getPacketSender().sendMessage("You have increased your penguin rate @blu@"
                        + player.getPointsHandler().getPengRate() + "@bla@ is now your total multiplier.");
                PlayerPanel.refreshPanel(player);
                player.getInventory().delete(5155, 1);
                break;
            case 5156:
                player.getPointsHandler().incrementPengRate(10000);
                player.getPacketSender().sendMessage("You have increased your penguin rate @blu@"
                        + player.getPointsHandler().getPengRate() + "@bla@ is now your total multiplier.");
                PlayerPanel.refreshPanel(player);
                player.getInventory().delete(5156, 1);
                break;
            case 7510:
                int plc = player.getConstitution();
                int plcr = plc - 1;

                if (plc == 1) {
                    plcr = 0;
                }

                if (plcr > 0) {
                    player.performAnimation(new Animation(829));
                    Hit h = new Hit(plcr);
                    player.dealDamage(h);
                    player.forceChat(Misc.randomElement(ROCK_CAKE));
                } else {
                    player.getPacketSender().sendMessage("You'll die if you keep eating this putrid rock!");
                }
                break;
            case 2550:
                int recoilcharges = (ItemDegrading.maxRecoilCharges - player.getRecoilCharges());
                player.getPacketSender().sendMessage("You have " + recoilcharges + " recoil "
                        + (recoilcharges == 1 ? "charge" : "charges") + " remaining.");
                break;
            case 681:
                int recoilcharges1 = (ItemDegrading.maxlordCharges - player.getRecoilCharges());
                player.getPacketSender().sendMessage("You have " + recoilcharges1 + " recoil "
                        + (recoilcharges1 == 1 ? "charge" : "charges") + " remaining.");
                break;
            // case 13738:
            case 13740:
            case 13742:
                // case 13744:
                if (player.isSpiritDebug()) {
                    player.getPacketSender().sendMessage("You toggle your Spirit Shield to not display specific messages.");
                    player.setSpiritDebug(false);
                } else if (player.isSpiritDebug() == false) {
                    player.getPacketSender().sendMessage("You toggle your Spirit Shield to display specific messages.");
                    player.setSpiritDebug(true);
                }
                break;
            case 23020:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                if (!player.getInventory().contains(23020) || player.getInventory().getAmount(23020) < 1) {
                    return;
                }
                int amt = player.getInventory().getAmount(23020);
                int minutesEXP = 30 * amt;
                int minutesDR = 5 * amt;
                int minutesDMG = 5 * amt;

                player.getInventory().delete(23020, amt);
                player.getInventory().add(ItemDefinition.UPGRADE_TOKEN_ID, 5_000  * amt);
                player.getPacketSender()
                        .sendMessage("@blu@You are rewarded " + (amt * 1) + " vote "
                                + (amt > 1 ? "points, " : "point, ") + (5_000 * amt) + " Upgrade tokens");
                player.getPacketSender()
                        .sendMessage("@blu@You received " + minutesDMG + " minutes of 100% Bonus DMG, and " + minutesDR + "minutes of 100% Bonus DR");
                player.getPointsHandler().incrementVotingPoints(amt * 1);
              //  BonusExperienceTask.addBonusXp(player, minutesEXP);
                VotingDRBoostTask.addBonusDR(player, minutesDR);
                 VotingDMGBoostTask.addBonusDMG(player, minutesDMG);
                StarterTasks.finishTask(player, StarterTaskData.REDEEM_A_VOTE_SCROLL);

                player.getClickDelay().reset();
                break;
            case 10138:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                VoteRewardHandler.AFKFISH(player, true);
                break;
            case 17634:
                if (player.busy()) {
                    player.getPacketSender().sendMessage("You can not do this right now.");
                    return;
                }
                VoteRewardHandler.AFKMINE(player, true);
                break;
            case 6500:
                CharmingImp.sendConfig(player);
                break;
            case 13281:
            case 13282:
            case 13283:
            case 13284:
            case 13285:
            case 13286:
            case 13287:
            case 13288:
            case 18819:
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendMessage(player.getSlayer().getSlayerTask() == SlayerTasks.NO_TASK
                        ? ("You do not have a Slayer task.")
                        : ("You're assigned to kill "
                        + player.getSlayer().getSlayerTask().getName()
                        + "s, only " + player.getSlayer().getAmountToSlay() + " more to go."));
                break;
            case 6570:
                if (player.getInventory().contains(6570) && player.getInventory().getAmount(6529) >= 50000) {
                    player.getInventory().delete(6570, 1).delete(6529, 50000).add(19111, 1);
                    player.getPacketSender().sendMessage("You have upgraded your Fire cape into a TokHaar-Kal cape!");
                } else {
                    player.getPacketSender().sendMessage(
                            "You need at least 50.000 Tokkul to upgrade your Fire Cape into a TokHaar-Kal cape.");
                }
                break;
            case 15262:
                if (!player.getClickDelay().elapsed(1300))
                    return;
                amt = player.getInventory().getAmount(15262);
                if (amt > 0)
                    player.getInventory().delete(15262, amt).add(18016, 10000 * amt);
                player.getClickDelay().reset();
                break;
            case 5509:
            case 5510:
            case 5512:
            case 5514:
                RunecraftingPouches.empty(player, RunecraftingPouch.forId(itemId));
                break;
            case 11283: // DFS
                player.getPacketSender()
                        .sendMessage("Your Dragonfire shield has " + player.getDfsCharges() + "/20 dragon-fire charges.");
                break;
        }
    }

    @Override
    public void handleMessage(Player player, Packet packet) {
        if (player.getConstitution() <= 0)
            return;

        switch (packet.getOpcode()) {
            case THIRD_ITEM_ACTION_OPCODE:
                thirdAction(player, packet);
                break;
            case FIRST_ITEM_ACTION_OPCODE:
                firstAction(player, packet);
                break;
            case SECOND_ITEM_ACTION_OPCODE:
                secondAction(player, packet);
                break;
        }
    }

}