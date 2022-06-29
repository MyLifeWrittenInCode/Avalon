package com.ruse.world.content.casketopening;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.boxes.*;
import com.ruse.world.content.casketopening.impl.*;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CasketOpening {

    private final Player player;
    private final int INTERFACE_ID = 110000;
    private boolean canCasketOpening = true;
    private Box SlotPrize;
    private Caskets currentCasket;
    public CasketOpening(Player player) {
        this.player = player;
    }


    public static Box getLoot(Box[] loot) {
        HashMap<Double, ArrayList<Box>> dropRates = new HashMap<>();
        ArrayList<Box> potentialDrops = new ArrayList<>();

        for (Box drop : loot) {
            if (drop == null)
                continue;
            double divisor = drop.getRate();
            if (!dropRates.containsKey(divisor)) {
                ArrayList<Box> items = new ArrayList<>();
                items.add(drop);
                dropRates.put(divisor, items);
            } else {
                dropRates.get(divisor).add(drop);
            }
        }
        for (double dropRate : dropRates.keySet()) {
            double rate = dropRate * 1000;
            if (Misc.getRandom(100000) <= rate) {
                potentialDrops.add(dropRates.get(dropRate).get(Misc.getRandom(dropRates.get(dropRate).size() - 1)));
            }
        }

        if (potentialDrops.size() > 0) {
            return potentialDrops.get(Misc.getRandom((potentialDrops.size() - 1)));
        } else {
            return loot[Misc.getRandom(1)];
        }
    }

    public static Box getLoot1(Box[] loot) {
        HashMap<Double, ArrayList<Box>> dropRates = new HashMap<>();
        ArrayList<Box> potentialDrops = new ArrayList<>();

        for (Box drop : loot) {
            if (drop == null)
                continue;
            double divisor = drop.getRate();
            if (!dropRates.containsKey(divisor)) {
                ArrayList<Box> items = new ArrayList<>();
                items.add(drop);
                dropRates.put(divisor, items);
            } else {
                dropRates.get(divisor).add(drop);
            }
        }
        for (double dropRate : dropRates.keySet()) {
            double rate = dropRate * 1000;
            if (Misc.getRandom(100000) <= rate) {
                potentialDrops.add(dropRates.get(dropRate).get(Misc.getRandom(dropRates.get(dropRate).size() - 1)));
            }
        }

        if (potentialDrops.size() > 0) {
            return potentialDrops.get(Misc.getRandom((potentialDrops.size() - 1)));
        } else {
            return loot[Misc.getRandom(loot.length - 1)];
        }
    }

    public boolean hasItems() {
        if (!player.getInventory().contains(getCurrentCasket().getItemID())) {
            player.sendMessage("You need a " + ItemDefinition.forId(getCurrentCasket().getItemID()).getName() + " to do this.");
            return false;
        }
        return true;
    }

    public boolean removeItems() {
        if (player.getInventory().getAmount(getCurrentCasket().getItemID()) >= 1) {
            player.getInventory().delete(getCurrentCasket().getItemID(), 1);
        }
        return false;
    }

    public boolean removeAllItems() {

        int amount = player.getInventory().getAmount(22053);

        if (player.getInventory().getAmount(getCurrentCasket().getItemID()) >= 1) {
            player.getInventory().delete(getCurrentCasket().getItemID(), amount);
        }
        return false;
    }

    public void spin() {
        if (getCurrentCasket() == null) {
            return;
        }

        if (!canCasketOpening) {
            player.sendMessage("Please finish your current spin.");
            return;
        }
        if (hasItems()) {
            if (player.getInventory().getFreeSlots() == 0) {
                player.getPacketSender().sendMessage("You don't have enough free inventory space.");
                return;
            }
            removeItems();
            player.setSpinning(true);
            player.getMovementQueue().setLockMovement(true);
            player.sendMessage(":resetCasket");
            player.sendMessage(":spinCasket");
            process();
        }
    }

    public void quickSpin() {
        if (getCurrentCasket() == null) {
            return;
        }
        if (!canCasketOpening) {
            player.sendMessage("Please finish your current spin.");
            return;
        }
        if (hasItems()) {
            if (player.getInventory().getFreeSlots() == 0) {
                player.getPacketSender().sendMessage("You don't have enough free inventory space.");
                return;
            }
            removeItems();
            player.sendMessage(":resetCasket");
            processQuick();
        }
    }

    public void process() {
        SlotPrize = null;
        canCasketOpening = false;
        Box[] loot =getCurrentCasket().getLoot() ;
        SlotPrize = getLoot1(loot);
        if (SlotPrize.getRate() < 10D && Misc.getRandom(1) == 0){
            SlotPrize = getLoot1(loot);
        }
        if (SlotPrize.getRate() < 10D && Misc.getRandom(2) == 0){
            SlotPrize = getLoot1(loot);
        }

        boolean announce = SlotPrize.isAnnounce();

        for (int i = 0; i < 28; i++) {
            Box NOT_PRIZE = getLoot1(loot);
            if (NOT_PRIZE.getRate() > 10 && Misc.getRandom(2) == 0) {
                NOT_PRIZE = getLoot1(loot);
            }
            sendItem(i, 23, SlotPrize.getId(), SlotPrize.getMax(), NOT_PRIZE.getId(), NOT_PRIZE.getMax(), 110501);
        }

        final boolean announceLoot = announce;
        TaskManager.submit(new Task(7, player, false) {

            @Override
            public void execute() {
                reward(announceLoot);
                player.setSpinning(false);
                player.getMovementQueue().setLockMovement(false);
                stop();
            }
        });
    }


    public void processQuick() {
        SlotPrize = null;
        canCasketOpening = false;
        Box[] loot =getCurrentCasket().getLoot() ;
        SlotPrize = getLoot1(loot);
        if (SlotPrize.getRate() < 10D && Misc.getRandom(1) == 0){
            SlotPrize = getLoot1(loot);
        }
        if (SlotPrize.getRate() < 10D && Misc.getRandom(2) == 0){
            SlotPrize = getLoot1(loot);
        }
        boolean announce = SlotPrize.isAnnounce();
        for (int i = 0; i < 7; i++) {
            Box NOT_PRIZE = getLoot1(loot);
            if (NOT_PRIZE.getRate() > 10 && Misc.getRandom(2) == 0) {
                NOT_PRIZE = getLoot1(loot);
            }
            sendItem(i, 3, SlotPrize.getId(), SlotPrize.getAmount(), NOT_PRIZE.getId(), NOT_PRIZE.getAmount(), 110501);
        }
         // player.getBank(0).add(new Item(SlotPrize.getId(), SlotPrize.getMax()), false);
       //   canCasketOpening = true;

        reward(announce);
        player.setSpinning(false);
    }

    public void sendItem(int i, int prizeSlot, int PRIZE_ID, int prizeamount, int NOT_PRIZE, int amount,
                         int ITEM_FRAME) {
        if (i == prizeSlot) {
            player.sendMessage("casketopening##" + ITEM_FRAME + "##" + PRIZE_ID + "##" + prizeamount + "##" + i + "##");
        } else {
            player.sendMessage("casketopening##" + ITEM_FRAME + "##" + NOT_PRIZE + "##" + amount + "##" + i + "##");
        }
    }


    public void reward(boolean announce) {
        if (SlotPrize == null) {
            return;
        }
        player.getInventory().add(SlotPrize.getId(), SlotPrize.getAmount());
        player.sendMessage(
                "@red@You won x" + SlotPrize.getAmount() + " " + ItemDefinition.forId(SlotPrize.getId()).getName());

        if (announce) {
            String message = "@red@" + player.getUsername() + " <col=ff812f>has just received @red@"
                    + (SlotPrize.getMax() > 1 ? "x" + SlotPrize.getMax() : "") + " "
                    + ItemDefinition.forId(SlotPrize.getId()).getName() + "<col=ff812f> from a @red@" +
                    ItemDefinition.forId(getCurrentCasket().getItemID()).getName() + "!";
            World.sendNewsMessage(message);
        }

        canCasketOpening = true;
    }

    public static List<Item> rare = Arrays.asList(
            new Item(23303, 1), // Mystic helmet
            new Item(23304, 1), // Mystic body
            new Item(23305, 1), // Mystic legs
            new Item(23306, 1), // Mystic legs
            new Item(23307, 1), // Mystic legs
            new Item(23308, 1), // Mystic legs
            new Item(23309, 1), // Mystic legs
            new Item(23310, 1), // Mystic legs
            new Item(23311, 1), // Mystic legs
            new Item(14999, 1), // Onyx casket
            new Item(23276, 1), // Bronze card pack
            new Item(15288, 250) // Upgrade token packs

    );

    public static List<Item> common = Arrays.asList(
            new Item(15288, 2), // x2 100k token pack
            new Item(5022, 100_000), // Pvm tickets
            new Item(7956, 5000), // pvm box t1
            new Item(19114, 50), // Grand mystery box
            new Item(20488, 5), // Grand mystery box
            new Item(11137, 75), // xp lamps
            new Item(20489, 1), // Launch casket
            new Item(15358, 1), // 30min effect scroll
            new Item(15359, 1), // 30min effect scroll
            new Item(15288, 5), // x5 100k token packs
            new Item(23321, 20), // Soulless crystal
            new Item(10946, 1), // $1 scroll
            new Item(4446, 1), // $1 scroll
            new Item(19886, 1), // $1 scroll
            new Item(8087, 1), // $1 scroll
            new Item(8088, 1), // $1 scroll
            new Item(8089, 1), // $1 scroll
            new Item(22006, 25), // Deathtouch darts
            new Item(15003, 1) // Silver chest
    );

    public void openSOSInterface() {
        player.sendMessage(":resetCasket");
        player.getPA().sendInterface(48130);
        player.getPacketSender().sendString(48135, "Suffering key");
        player.getPacketSender().sendItemOnInterface(48145, 22053, 0, 1);


        for (int i = 0; i < common.size(); i++) {
                player.getPacketSender().sendItemOnInterface(48151, common.get(i).getId(),i, common.get(i).getAmount());
        }

        for (int i = 0; i < rare.size(); i++) {
                player.getPacketSender().sendItemOnInterface(48171, rare.get(i).getId(),i, rare.get(i).getAmount());
        }

    }

    public void openInterface() {
        player.sendMessage(":resetCasket");

        player.getPacketSender().sendItemOnInterface(110009, 13759, 1);
        player.getPacketSender().sendItemOnInterface(110010, 13758, 1);

        Box[] loot = getCurrentCasket().getLoot();

        int length = loot.length;
        if (length >= 160)
            length = 160;
        if (length <= 16)
            length = 16;

        length += 8 - (length % 8);

        for (int i = 0; i < length; i++) {
            if (loot.length > i)
                player.getPacketSender().sendItemOnInterface(110101 + i, loot[i].getId(), loot[i].getMax());
            else
                player.getPacketSender().sendItemOnInterface(110101 + i, -1, 0);
        }

        for (int i = 0; i < length; i++) {
            if (loot.length > i)
                player.getPacketSender().sendString(110261 + i, "1/" + getRate(loot[i].getRate()));
            else
                player.getPacketSender().sendString(110261 + i, "");
        }
        int scroll = 9 + ((loot.length / 8) + 1) * 55;
        if (scroll <= 165)
            scroll = 165;
        player.getPacketSender().setScrollBar(110100, scroll);


        player.getPA().sendInterface(INTERFACE_ID);
    }

    public int getRate(double rate) {
        int result = (int) (100 / rate);
        return result;
    }


    public Caskets getCurrentCasket() {
        return currentCasket;
    }

    public void setCurrentCasket(Caskets currentCasket) {
        this.currentCasket = currentCasket;
    }

    public enum Caskets {

        RARE_BOX(23171, RareBox.loot),
        DEF_BOX(23172, DefBox.loot),
        OFF_BOX(23173, OffBox.loot),
        WEAPON_BOX(19114, WepBox.loot),
        HOV_BOX(23086, HOVBox.loot),
        EMERALD_CASKET(15003, Silver.rewards),
        ONYX_CASKET(14999, Onyx.rewards),
        RUBY_CASKET(15002, Ruby.rewards),
        DIAMOND_CASKET(15004, Diamond.rewards),
        RAIDS(18404, Raids1.rewards),
        ZENYTE_CASKET(23253, Zenyte.rewards),
        SOSREWARDS(22053, SOSRewards.rewards),
        ;
        private int itemID;
        private Box[] loot;

        Caskets(int itemID, Box[] loot) {
            this.itemID = itemID;
            this.loot = loot;
        }

        public int getItemID() {
            return itemID;
        }

        public Box[] getLoot() {
            return loot;
        }

    }

}