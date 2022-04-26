package com.ruse.world.content.skill.impl.thieving;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.AfkSystem;
import com.ruse.world.content.achievement.Achievements;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.cluescrolls.OLD_ClueScrolls;
import com.ruse.world.content.skill.impl.mining.MiningData;
import com.ruse.world.entity.impl.player.Player;

import static mysql.impl.Donation.EMERALD_DONATION_AMOUNT;
import static mysql.impl.Donation.SAPPHIRE_DONATION_AMOUNT;

public class Stalls {

    public static Box[] loot1 = new Box[]{
            new Box(5022, 1, 2, 100),  //Pvm tickets
            new Box(5022, 3, 4, 75),  //Pvm tickets
            new Box(5020, 1, 2, 100),  //Afk tickets
            new Box(5020, 3, 4, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 1, 2, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 2, 4, 60),  //Orbs
            new Box(6199, 1, 0.4D),  //mystery box
            new Box(23204, 1, 3D),  //sapphire fragment
            new Box(7956, 1, 0.3D),  //Pvm box
            new Box(19116, 0.05D), //Super mbox
    };
    public static Box[] loot2 = new Box[]{
            new Box(5022, 2, 4, 100),  //Pvm tickets
            new Box(5022, 6, 8, 75),  //Pvm tickets
            new Box(5020, 2, 4, 100),  //Afk tickets
            new Box(5020, 6, 8, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 2, 4, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 4, 8, 60),  //Orbs
            new Box(6199, 3, 0.3D),  //mystery box
            new Box(23205, 1, 3D),  //emerald fragment
            new Box(7956, 3, 0.2D),  //Pvm box
            new Box(19115, 0.05D), //Ext mbox
    };
    public static Box[] loot3 = new Box[]{
            new Box(5022, 4, 8, 100),  //Pvm tickets
            new Box(5022, 12, 16, 75),  //Pvm tickets
            new Box(5020, 4, 8, 100),  //Afk tickets
            new Box(5020, 12, 16, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 4, 8, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 8, 16, 60),  //Orbs
            new Box(6199, 7, 0.3D),  //mystery box
            new Box(23206, 1, 3D),  //ruby fragment
            new Box(7956, 7, 0.2D),  //Pvm box
            new Box(19114, 0.05D), //Grand mbox
            new Box(10946, 0.01D), //$1 scroll
    };
    public static Box[] loot4 = new Box[]{
            new Box(5022, 8, 16, 100),  //Pvm tickets
            new Box(5022, 24, 32, 75),  //Pvm tickets
            new Box(5020, 8, 16, 100),  //Afk tickets
            new Box(5020, 24, 32, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 8, 16, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 16, 32, 60),  //Orbs
            new Box(6199, 7, 0.9D),  //mystery box
            new Box(23207, 1, 3D),  //diamond fragment
            new Box(7956, 7, 0.6D),  //Pvm box
            new Box(19114, 0.15D), //Grand mbox
            new Box(10946, 0.03D), //$1 scroll
    };
    public static Box[] loot5 = new Box[]{
            new Box(5022, 8, 16, 100),  //Pvm tickets
            new Box(5022, 24, 32, 75),  //Pvm tickets
            new Box(5020, 8, 16, 100),  //Afk tickets
            new Box(5020, 24, 32, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 8, 16, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 16, 32, 60),  //Orbs
            new Box(6199, 7, 0.9D),  //mystery box
            new Box(23208, 1, 3D),  //onyx fragment
            new Box(7956, 7, 0.6D),  //Pvm box
            new Box(19114, 0.15D), //Grand mbox
            new Box(10946, 0.03D), //$1 scroll
    };
    public static Box[] loot6 = new Box[]{
            new Box(5022, 8, 16, 100),  //Pvm tickets
            new Box(5022, 24, 32, 75),  //Pvm tickets
            new Box(5020, 8, 16, 100),  //Afk tickets
            new Box(5020, 24, 32, 70),  //Afk tickets
            new Box(ItemDefinition.MILL_ID, 8, 16, 100),  //Orbs
            new Box(ItemDefinition.MILL_ID, 16, 32, 60),  //Orbs
            new Box(6199, 7, 0.9D),  //mystery box
            new Box(23209, 1, 3D),  //zenyte fragment
            new Box(7956, 7, 0.6D),  //Pvm box
            new Box(19114, 0.15D), //Grand mbox
            new Box(10946, 0.03D), //$1 scroll
    };
    public static void stealFromStall(Player player, GameObject  gameObject, int lvlreq, int xp, Item reward, String message) {
        if (player.getInventory().getFreeSlots() < 1) {
            player.getPacketSender().sendMessage("You need some more inventory space to do this.");
            return;
        }
        if (player.getCombatBuilder().isBeingAttacked()) {
            player.getPacketSender()
                    .sendMessage("You must wait a few seconds after being out of combat before doing this.");
            return;
        }
        if (!player.getClickDelay().elapsed(2000))
            return;
        if (player.getSkillManager().getMaxLevel(Skill.THIEVING) < lvlreq) {
            player.getPacketSender()
                    .sendMessage("You need a Thieving level of at least " + lvlreq + " to steal from this stall.");
            return;
        }

        if (gameObject.getId() == 22772)
        Achievements.doProgress(player, Achievements.Achievement.STEAL_100_LAMP_STALLS);
        
        if (gameObject.getId() == 22774) {
            Achievements.doProgress(player, Achievements.Achievement.STEAL_250_ARMOUR_STALLS);
            Achievements.doProgress(player, Achievements.Achievement.STEAL_750_ARMOUR_STALLS);
        }

        player.performAnimation(new Animation(881));
        player.getPacketSender().sendInterfaceRemoval();
        player.getSkillManager().addExperience(Skill.THIEVING, xp);
        player.getClickDelay().reset();
        {
            player.getPacketSender().sendMessage(message);
            player.getInventory().add(reward);
        }
        player.getSkillManager().stopSkilling();
    }

    public static void stealFromAFKStall(Player player, int objectId, int tier) {
        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();
        if (!player.getClickDelay().elapsed(2000))
            return;
        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You need some more inventory space to do this.");
            return;
        }
        if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
            player.getPacketSender().sendMessage("You cannot do that right now.");
            return;
        }


        int accounts = 1;
        for (Player p : World.getPlayers()) {
            if (p == null)
                continue;
            if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
                if (p.getInteractingObject() != null && (p.getInteractingObject().getId() == 52601
                        || p.getInteractingObject().getId() == 53654 || p.getInteractingObject().getId() == 30035)) {
                    accounts++;
                    continue;
                }
            }
        }
        if (accounts > 2){
            player.getPacketSender().sendMessage("You already have two accounts mining afk.");
            return;
        }

        player.setCurrentTask(new Task(4, player, true) {

            @Override
            public void execute() {
                if (player.getInventory().getFreeSlots() <= 0) {
                    player.getPacketSender().sendMessage("You do not have any free inventory space left.");
                    this.stop();
                    return;
                }

                final int pickaxe = MiningData.getPickaxe(player);

                if (MiningData.isHoldingPickaxe(player) || (player.getInventory().contains(pickaxe))) {
                    player.performAnimation(new Animation(12003));
                    Box[] loot = loot1;
                    if (tier == 1) {
                        player.setAfkSapphire(player.getAfkSapphire() + 1);
                    } else if (tier == 2) {
                        loot = loot2;
                        player.setAfkEmerald(player.getAfkEmerald() + 1);
                    } else if (tier == 3) {
                        loot = loot3;
                        player.setAfkbRuby(player.getAfkbRuby() + 1);
                    } else if (tier == 4) {
                        loot = loot4;
                        player.setAfkDiamond(player.getAfkDiamond() + 1);
                    } else if (tier == 5) {
                        loot = loot5;
                        player.setAfkOnyx(player.getAfkOnyx() + 1);
                    } else if (tier == 6) {
                        loot = loot6;
                        player.setAfkZenyte(player.getAfkZenyte() + 1);
                    }

                    Box reward = CasketOpening.getLoot(loot);
                    player.getInventory().add(reward.getId(), reward.getMin() + Misc.getRandom(reward.getMax() - reward.getMin()));
                    AfkSystem.thievedCount++;
                    player.getInventory().refreshItems();
                    player.getClickDelay().reset();
                    return;
                } else
                    this.stop();
                    player.getPacketSender().sendMessage("You don't have a pickaxe to mine this rock with.");
            }

            @Override
            public void stop() {
                setEventRunning(false);
                player.performAnimation(new Animation(65535));
            }
        });
        TaskManager.submit(player.getCurrentTask());
    }
}
