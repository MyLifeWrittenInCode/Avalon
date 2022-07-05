package com.ruse.world.content.quests;

import com.ruse.world.entity.impl.player.Player;


public class QuestInterfaceHandler {
    private final Player player;

    public QuestInterfaceHandler(Player player) {this.player = player;}
    public void openQuestOne() {
        player.getPacketSender().sendInterface(77830);
        player.getPacketSender().sendString(77833, "Blood Runs Deep");
        player.getPacketSender().sendString(77836, (player.questOneStarted == true) ?
                "@gre@ - I Spoke with Ksenia and offered my help." : "@red@ - Speak to Ksenia and accept the Quest");
        player.getPacketSender().sendString(77837, "");
        player.getPacketSender().sendString(77838, (player.getQuestOneStep1() == true) ?
                "@gre@ - Travel to The sick man's dream world" : "@red@ - Travel to The sick man's dream world");
        player.getPacketSender().sendString(77839, "");
        player.getPacketSender().sendString(77840, (player.getQuestOneStep2() == true) ?
                    "@gre@ - Create a Lectern inside the dream" : "@red@- Create a Lectern inside the dream");
        player.getPacketSender().sendString(77841, " ");
        player.getPacketSender().sendString(77842, (player.getQuestOneStep3() == true) ?
                "@gre@ - Fight off the Dagganoth Army ("  + player.getPointsHandler().getQuestOneDreamKC() + "/50)" : "@red@ - Fight off the Dagganoth Army ("  + player.getPointsHandler().getQuestOneDreamKC() + "/50)");
        player.getPacketSender().sendString(77843, " ");
        player.getPacketSender().sendString(77844, (player.getQuestOneStep4() == true) ?
                "@gre@ - Access the Spiritual Realm" : "@red@ - Access the Spiritual Realm");
        player.getPacketSender().sendString(77845, " ");
        player.getPacketSender().sendString(77846, (player.getQuestOneStep5() == true) ?
                    "@gre@ - Retrieve the Prophecy tablet" : "@red@ - Retrieve the Prophecy tablet");
        player.getPacketSender().sendString(77847, " ");
        player.getPacketSender().sendString(77848, (player.getQuestOneStep6() == true) ?
                "@gre@ - Help craft the Dagonnoth Lair Teleport" : "@red@ - Help craft the Dagonnoth Lair Teleport");
        player.getPacketSender().sendString(77849, "");
        player.getPacketSender().sendString(77850, (player.getQuestOneStep7() == true) ?
                "@gre@ - Return the Enchanted Herbs to Ksenia" : "@red@ - Return the Enchanted Herbs to Ksenia");
        player.getPacketSender().sendString(77851, " ");
        player.getPacketSender().sendString(77852, (player.getQuestOneStep7() == true) ?
                "@gre@ Quest Complete" : "");
    }
}