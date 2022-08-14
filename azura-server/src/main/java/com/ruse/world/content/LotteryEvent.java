package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.util.NameUtils;
import com.ruse.world.World;
import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;
import com.ruse.world.entity.impl.player.PlayerLoading;
import com.ruse.world.entity.impl.player.PlayerSaving;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

public class LotteryEvent {
    public static void setdate(int hour, int minute){//only change this
        LotteryData lottery = World.getServerData().getTopLottery();

        // Date date = calendar.getTime();
        Date date = new GregorianCalendar(World.getCalendar().getInstance().get(Calendar.YEAR), Calendar.AUGUST, 14, hour, minute).getTime();
        lottery.setDate(date);
        System.out.println(lottery.getDate().toString());
        World.getServerData().setTopLottery(lottery);
        World.getServerData().processQueue();

    }
    public static boolean warningannounced = false;
    public static int TICKET_VALUE = 25_000;

    public static void checkpurchaseticket(Player player) {
        player.getPacketSender().sendInterfaceRemoval();
        if(!player.getInventory().contains(12855,TICKET_VALUE)) {
            player.sendMessage("You need at least "+Misc.insertCommasToNumber(String.valueOf(TICKET_VALUE))+" Upgrade tokens to purchase a ticket.");
            return;
        }



        LotteryData lottery = World.getServerData().getTopLottery();
        if (lottery.getEntries().containsKey(player.getUsername())) {
            player.sendMessage("You have already purchased a ticket!");
            return;
        }
        World.getServerData().getTopLottery().update(player.getUsername(), TICKET_VALUE);
        player.getInventory().delete(995,TICKET_VALUE);
        player.sendMessage("You have entered the lottery! Good luck! Total entries: " + World.getServerData().getTopLottery().getEntries().size());

    }

    public static String whenwinnersdrawn() {
        LotteryData lottery = World.getServerData().getTopLottery();
        Date enddate_week =  lottery.getDate();

        Date date = new Date();
        String result = Misc.get_duration(date, enddate_week);
        return result;
    }
    public static void whenwinnersdrawn(Player p) {
        DialogueManager.start(p, new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public int npcId() {
                return 4650;
            }

            @Override
            public String[] dialogue() {


                return new String[] { "The winner will be drawn in "+whenwinnersdrawn()+"" };
            }

            @Override
            public Dialogue nextDialogue() {
                return DialogueManager.getDialogues().get(12111);
            }
        });
    }
    public static void initialdialogue(Player p) {
        DialogueManager.start(p, new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.OPTION;
            }

            @Override
            public int npcId() {
                return 4650;
            }

            @Override
            public DialogueExpression animation() {
                return null;
            }

            @Override
            public String[] dialogue() {
                //    boolean inDuo = player.getSlayer().getDuoPartner() != null;
                return new String[] { "Purchase ticket", "How much is in the pot?", "When is the winner chosen?"

                };
            }

            @Override
            public void specialAction() {
                p.setDialogueActionId(12111);
            }
        });
    }

    public static void getCurrentPot(Player p) {
        DialogueManager.start(p, new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public int npcId() {
                return 4650;
            }

            @Override
            public String[] dialogue() {
                LotteryData lottery = World.getServerData().getTopLottery();

                return new String[] { "The pot is currently at:",
                        " "+Misc.insertCommasToNumber(String.valueOf(lottery.getTotalPot()))+" Upgrade tokens." };
            }

            @Override
            public Dialogue nextDialogue() {
                return DialogueManager.getDialogues().get(12111);
            }
        });
    }

    public static void purchaseTicket(Player p) {
        DialogueManager.start(p, new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public int npcId() {
                return 4650;
            }

            @Override
            public String[] dialogue() {

                return new String[] { "A lottery ticket costs "+Misc.insertCommasToNumber(String.valueOf(TICKET_VALUE))+" Upgrade tokens" };
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public int npcId() {
                        return 4650;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        //    boolean inDuo = player.getSlayer().getDuoPartner() != null;
                        return new String[] { "Purchase ticket for  "+Misc.insertCommasToNumber(String.valueOf(TICKET_VALUE))+" Upgrade tokens" , "Cancel"

                        };
                    }

                    @Override
                    public void specialAction() {
                        p.setDialogueActionId(12112);
                    }
                };
            }
        });
    }
    public static void handleRewards() {
        LotteryData lottery = World.getServerData().getTopLottery();

        Calendar calendar = World.getCalendar().getInstance();
        Date date = calendar.getTime();
        if (calendar.getTime().after(lottery.get20minutedate()) && !warningannounced) {
            World.sendMessage("[LOTTERY] The lottery will be drawn in 20 minutes!");
            warningannounced = true;
            return;
        }

        if (calendar.getTime().after(lottery.getDate())) {
            date = DateUtils.addDays(date, 1);
            lottery.setDate(date);
            lottery.setDate20minsbefore(date);
            //    System.out.println(wogw.getDate().toString());


            ArrayList<Map.Entry<String, Integer>> winners = lottery.getSortedResultsForWinners();

            Map<String, Integer> winnerMap = new HashMap<>();
            winners.forEach(entry -> winnerMap.put(entry.getKey(), entry.getValue()));


            Item totalpot = new Item(995, lottery.getTotalPot());

            if (winners.size() == 0) { // no winners
                lottery.setWinners(winnerMap);
            } else {
                lottery.setWinners(winnerMap);

                StringBuilder s = new StringBuilder();
                for (Map.Entry<String, Integer> entry : winners) {
                    Player playerToGive = World.getPlayerByName(entry.getKey());
                    s.append(entry.getKey());



                    if (playerToGive == null) { // if player is offline add the item to his bank


                        Player player = new Player(null);
                        player.setUsername(entry.getKey());
                        player.setLongUsername(NameUtils.stringToLong(entry.getKey()));

                        PlayerLoading.getResult(player, true);

                        player.depositItemBank(totalpot);
                        PlayerSaving.save(player);


                        continue;
                    }
                    playerToGive.getInventory().add(12855,lottery.getTotalPot());
                    playerToGive.sendMessage("Congratulations you are the winner of the "+ Misc.insertCommasToNumber(String.valueOf(lottery.getTotalPot()))+" Upgrade tokens!");

                }
                World.sendMessage("[LOTTERY] The lottery has ended! Congratulations to "+s+" for winning "+Misc.insertCommasToNumber(String.valueOf(lottery.getTotalPot()))+" Upgrade tokens!");


//                try(FileWriter fw = new FileWriter("data/lotterywinners/lotterywinners.txt", true);
//                    BufferedWriter bw = new BufferedWriter(fw);
//                    PrintWriter out = new PrintWriter(bw)) {
//                    out.println("winner: "+s);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }


            lottery.clear();
            World.getServerData().setTopLottery(lottery);
            World.getServerData().processQueue();

        } else {
            //    System.out.println("It's not time yet.");
        }
    }

}
