package com.ruse.world.content.cardPacks;

import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SilverCardPack {
    public static final int[] CARD_IDS = {
            /*blue card*/ 23277
    };
    public static boolean isCard(final int itemId) {
        for (int nest : CARD_IDS) {
            if (nest == itemId) {
                return true;
            }
        }
        return false;
    }
    public static int cardbeingused = -1;
    public static final void openCard(Player player, int itemId) {
        if (player.getInventory().getFreeSlots() < 6) {
            player.getPacketSender().sendMessage("You do not have enough free inventory slots to do this.");
            return;
        }
        cardbeingused = itemId;
        player.getPacketSender().sendInterface(23580); // Open the interface.

        player.getPacketSender().sendItemOnInterface(23587, 23277, 1);
    }
    public static List<Box> bronzeRewards = Arrays.asList(
            new Box(4446, 1,1, 33,false, "bronze"),
            new Box(19886, 1,1, 33,false, "bronze"),
            new Box(1486, 1,1, 33,false, "bronze"),
            new Box(20489, 1,1, 33,false, "bronze"),
            new Box(20489, 1,2, 33,false, "bronze"),
            new Box(10946, 5,10, 33,false, "bronze"),
            new Box(15288, 5,20, 33,false, "bronze"),
            new Box(5022, 300_000,1_000_000, 33,false, "bronze"),
            new Box(6769, 1,1, 33,false,"bronze"),
            new Box(10942, 1,1, 33,false, "bronze"),
            new Box(4278, 150,300, 33,false, "bronze")

    );

    public static List<Box> silverRewards = Arrays.asList(
            new Box(15359, 3,5, 33,false, "silver"),
            new Box(15358, 3,5, 33,false, "silver"),
            new Box(19115, 75,200, 33,false, "silver"),
            new Box(19114, 25,100, 33,false, "silver"),
            new Box(23174, 1,3, 33,false, "silver"),
            new Box(15290, 150,300, 33,false, "silver"),
            new Box(15289, 30,75, 33,false, "silver"),
            new Box(23046, 1,1, 33,false, "silver"),
            new Box(20488, 5,15, 33,false, "silver"),
            new Box(3739, 1,1, 33,false, "silver"),
            new Box(3738, 1,1, 33,false, "silver"),
            new Box(3737, 1,1, 33,false, "silver"),
            new Box(8087, 1,1, 33,false, "silver"),
            new Box(8088, 1,1, 33,false, "silver"),
            new Box(8089, 1,1, 33,false, "silver"),
            new Box(11137, 50,200, 33,false, "silver"),
            new Box(19888, 1,1, 33,false, "silver"),
            new Box(18823, 1,1, 33,false, "silver"),
            new Box(23264, 25,50, 33,false, "silver")
    );

    public static List<Box> goldRewards = Arrays.asList(
            new Box(21220, 400,1000, 33,false,  "gold"),
            new Box(23215, 100,250, 33,false,  "gold"),
            new Box(22219, 50,100, 33,false,  "gold"),
            new Box(21218, 15,30, 33,false,  "gold"),
            new Box(22006, 15,50, 33,false,  "gold"),
            new Box(20489, 3,10, 33,false,  "gold"),
            new Box(10946, 10,30, 33,false,  "gold"),
            new Box(6769, 2,5, 33,false, "gold"),
            new Box(4278, 500,1000, 33,false, "gold"),
            new Box(15359,6,20, 33, false,"gold"),
            new Box(15358,6,20, 33, false,"gold"),
            new Box(19114,200,500,  33,false,"gold"),
            new Box(23174,5,20, 33, false,"gold"),
            new Box(15290,750,1500,  33,false,"gold"),
            new Box(15289,100,250, 33,false,"gold"),
            new Box(23048,1,1, 33, false,"gold"),
            new Box(23049,1,1, 33, false,"gold"),
            new Box(20488,25,75,  33,false,"gold"),
            new Box(11137,250,1000, 33, false,"gold")
    );

    public static List<Box> diamondRewards = Arrays.asList(

            new Box(23264,125,250, 33, false,"diamond"),
            new Box(21220,2500,5000,  33,false,"diamond"),
            new Box(23215,750,1250, 33, false,"diamond"),
            new Box(22219,200,500,  33,false,"diamond"),
            new Box(21218,50,150, 33, false,"diamond"),
            new Box(22006,75,250, 33, false,"diamond"),
            new Box(15003,2,4, 33, false,"diamond"),
            new Box(15002,1,2, 33, false,"diamond"),
            new Box(23002,1,2, 33, false,"diamond"),
            new Box(15004,1,1, 33, false,"diamond"),
            new Box(10934,1,1, 33, false,"diamond"),
            new Box(18818,1,1,  33,false,"diamond"),
            new Box(18888,1,1, 33, false,"diamond"),
            new Box(18881,1,1, 33, false,"diamond"),
            new Box(18883,1,1, 33, false,"diamond"),
            new Box(19810,1,1, 33, false,"diamond"),
            new Box(10942,1,1, 33, false,"diamond"),
            new Box(9084,1,1, 33, false,"diamond"),
            new Box(10947,10,25, 33, false,"diamond"),
            new Box(3737,1,2, 33, false,"diamond"),
            new Box(3738,1,1, 33,false,"diamond"),
            new Box(3739,1,1,33, false,"diamond")
    );


    public static List<Box> tanzaniteRewards = Arrays.asList(
            new Box(12630,1,1, 33,true,"tanzanite"),
            new Box(9083,1,1,33, true,"tanzanite"),
            new Box(20591,1,1,33, true,"tanzanite"),
            new Box(10949,2,3,33, true,"tanzanite"),
            new Box(3578,1,1,33, true,"tanzanite"),
            new Box(14999,1,1,33, true,"tanzanite"),
            new Box(22121,1,1, 33,true,"tanzanite"),
            new Box(23240,1,1,33, true,"tanzanite"),
            new Box(10943,1,1,33, true,"tanzanite"),
            new Box(23002,2,2,33, true,"tanzanite"),
            new Box(15004,2,2, 33,true,"tanzanite"),
            new Box(5012,1,1,33, true,"tanzanite"),
            new Box(12535,1,1, 33,true,"tanzanite"),
            new Box(17011,1,1,33, true,"tanzanite"),
            new Box(4684,1,1,33, true,"tanzanite"),
            new Box(4685,1,1,33, true,"tanzanite"),
            new Box(4686,1,1,33, true,"tanzanite"),
            new Box(20489,15,25,33, true,"tanzanite"),
            new Box(10946,25,75,33, true,"tanzanite"),
            new Box(10946,25,50,33, true,"tanzanite"),
            new Box(6769,5,10,33, true,"tanzanite"),
            new Box(6769,6,12,33, true,"tanzanite"),
            new Box(19114,750,1500,33, true,"tanzanite"),
            new Box(23174,20,30,33, true,"tanzanite"),
            new Box(20488,100,200,33, true,"tanzanite"),
            new Box(23264,500,750,33, true,"tanzanite"),
            new Box(23215,1000,2000,33, true,"tanzanite"),
            new Box(15003,3,6,33, true,"tanzanite"),
            new Box(15002,2,3,33, true,"tanzanite"),
            new Box(10934,2,3,33, true,"tanzanite"),
            new Box(22113,1,1,33, true,"tanzanite"),
            new Box(22114,1,1,33, true,"tanzanite"),
            new Box(22115,1,1,33, true,"tanzanite"),
            new Box(22105,1,1,33, true,"tanzanite"),
            new Box(23253,1,1,33, true,"tanzanite"),
            new Box(3578,2,2,33, true,"tanzanite"),
            new Box(14999,2,2,33, true,"tanzanite"),
            new Box(22121,2,2,33, true,"tanzanite"),
            new Box(23240,2,2,33, true,"tanzanite"),
            new Box(10935,2,2,33, true,"tanzanite"),
            new Box(23002,4,4,33, true,"tanzanite"),
            new Box(15004,2,2,33, true,"tanzanite"),
            new Box(10946,75,125,33, true,"tanzanite"),
            new Box(6769,10,20,33, true,"tanzanite"),
            new Box(19114,2000,3000,33, true,"tanzanite"),
            new Box(23174,50,75,33, true,"tanzanite"),
            new Box(15002,3,5,33, true,"tanzanite")
    );

    public static int getRarityColor(Box reward){
        int spriteId = 1673;//blank
        switch(reward.getRarityofItem()){
            case "bronze":
                spriteId = 1674;
                break;
            case "silver":
                spriteId = 1675;
                break;
            case "gold":
                spriteId = 1676;

                break;
            case "diamond":
                spriteId = 1677;
                break;
            case "tanzanite":
                spriteId = 1678;
                break;

        }

        return spriteId;
    }
    public static void testcard(Player player){
        if(!player.getInventory().contains(cardbeingused)){
            player.sendMessage("You have no more cards left.");
            return;
        }
        player.getPacketSender().sendItemOnInterface(23587, -1, 1);
        player.getPacketSender().sendInterface(23480); // Open the interface.

        for (int i = 23487; i < 23493; i++)
            player.getPacketSender().sendItemOnInterface(i, -1, 1);


        player.getInventory().delete(cardbeingused, 1);
        Box reward;
        List<Box> rewardstype;//default
        for(int i = 0; i < 6; i++){
            int chance = Misc.random(100);
            if(chance >=35 && chance < 70){
                rewardstype = silverRewards;//30% chance

            }else if(chance >=18 && chance <35){//20% chance
                rewardstype = goldRewards;

            }else if(chance >=3 && chance < 18){//10% chance
                rewardstype = diamondRewards;

            }else if(chance < 3){//1% chance
                rewardstype = tanzaniteRewards;

            } else {
                rewardstype = bronzeRewards;
            }

            reward = getRandomItem(rewardstype);
            player.getPacketSender().sendSpriteChange(23494+i, getRarityColor(reward));
            player.getPacketSender().sendItemOnInterface(23487+i, reward.getId(), reward.getAmount());
            player.getInventory().add(reward.getId(),reward.getAmount());

            if (rewardstype == tanzaniteRewards) {
                World.sendMessage("<img=832> @red@" +player.getUsername() + " <col=ff812f>has just received @red@"
                        + "x" + (reward.getAmount()) + " "
                        + ItemDefinition.forId(reward.getId()).getName() + "<col=ff812f> from a @red@ Quill's Card Pack!");
            }
        }
    }

    public static Box getRandomItem(List<Box> items) {
        return items.get(new Random().nextInt(items.size()));
    }
}
