package com.ruse.world.content.raids.legends;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class ZombieRaids {

    public static void start(ZombieRaidsParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();

        System.out.println(party.getOwner() == null ? "null" : "not null");

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in a raids!");
            return;
        }

        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the fight.");
            return;
        }

        for (Player member : party.getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendInterfaceRemoval();
                if (member.getSummoning().getFamiliar() != null) {
                    member.getPacketSender()
                            .sendMessage("You must dismiss your familiar before being allowed to enter a dungeon.");
                    p.getPacketSender().sendMessage(
                            "" + p.getUsername() + " has to dismiss their familiar before you can enter the dungeon.");
                    return;
                }
            }
        }

        party.enteredDungeon(true);
        final int height = p.getIndex() * 4;
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.ZOMBIE, height, null));

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(2253, 4113 , height));
            PrayerHandler.deactivateAll(member);
            CurseHandler.deactivateAll(member);
            TaskManager.submit(new Task(2, false) {

                @Override
                public void execute() {
                    PrayerHandler.deactivateAll(member);
                    CurseHandler.deactivateAll(member);
                    stop();
                }


            });
            member.getSkillManager().stopSkilling();
            member.getPacketSender().sendClientRightClickRemoval();
            member.getPacketSender().sendCameraNeutrality();
            member.setInsideRaids(false);
            member.setEnteredZombieRaids(false);
            //member.getPacketSender().sendFade(25, 50, 50);
            member.setZombieRaidsParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("@red@Welcome to the League of Legends Raids");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startLegendsRaid();

    }

    public static NPC addNpc(ZombieRaidsParty party, int npcId, double mult) {
        NPC npc = (new NPC(npcId, new Position(2244 + Misc.getRandom(16), 4104 + Misc.getRandom(19), party.getHeight())));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        return npc;
    }

    public static void firstWave(ZombieRaidsParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 2500;

        for (int i = 0; i < 8; i++) {
            npcs.add(addNpc(party, ZombieRaidData.firstWaveNpc, mult));
        }
        for (int i = 0; i < (party.getPlayers().size() - 1) * 2; i++) {
            npcs.add(addNpc(party, ZombieRaidData.firstWaveNpc, mult));
        }
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startLegendTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void secondWave(ZombieRaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 5000;

        for (int i = 0; i < 6; i++) {
            npcs.add(addNpc(party, ZombieRaidData.secondWaveNpc, mult));
        }
        for (int i = 0; i < (party.getPlayers().size() - 1) * 2; i++) {
            npcs.add(addNpc(party, ZombieRaidData.secondWaveNpc, mult));
        }
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startLegendTask(party, npcs, 2);
                stop();
            }
        });
    }

    public static void thirdWave(ZombieRaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 10000;

        for (int i = 0; i < 5; i++) {
            npcs.add(addNpc(party, ZombieRaidData.thirdWaveNpc, mult));
        }
        for (int i = 0; i < (party.getPlayers().size() - 1) * 1; i++) {
            npcs.add(addNpc(party, ZombieRaidData.thirdWaveNpc, mult));
        }
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startLegendTask(party, npcs, 3);
                stop();
            }
        });
    }

    public static void fourthWave(ZombieRaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 20000;

        for (int i = 0; i < 4; i++) {
            npcs.add(addNpc(party, ZombieRaidData.fourthWaveNpc, mult));
        }
        for (int i = 0; i < (party.getPlayers().size() - 1) * 1; i++) {
            npcs.add(addNpc(party, ZombieRaidData.fourthWaveNpc, mult));
        }
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startLegendTask(party, npcs, 4);
                stop();
            }
        });
    }

    public static void fifthWave(ZombieRaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();

        double mult = 100000;

        NPC npc = new NPC(ZombieRaidData.fifthWaveNpc, new Position(2257, 4115, party.getHeight()));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npcs.add(npc);

        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startLegendTask(party, npcs, 5);
                stop();
            }
        });
    }

    public static void startLegendTask(ZombieRaidsParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.ZOMBIE)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to defeat the Raids [2]");
                            destroyInstance(party);
                            stop();
                            
                            
                        }

                        if (!party.hasEnteredRaids())
                            stop();

                        int count = 0;
                        for (NPC npc : npcs) {
                            if (npc.getConstitution() <= 0)
                                count++;
                        }
                        if (count >= npcs.size()) {
                            if (wave == 1)
                                secondWave(party);
                            else if (wave == 2)
                                thirdWave(party);
                            else if (wave == 3)
                                fourthWave(party);
                            else if (wave == 4)
                                fifthWave(party);
                            else
                                finishRaid(party);
                            stop();
                        }

                        if (tick == 4) {
                            if (wave == 1)
                                party.sendMessage("@red@The League of Legends Raids have started!");
                            else if (wave == 2)
                                party.sendMessage("@red@The second wave has started!");
                            else if (wave == 3)
                                party.sendMessage("@red@The third wave has started!");
                            else if (wave == 4)
                                party.sendMessage("@red@The fourth wave has started!");
                            else if (wave == 5)
                                party.sendMessage("@red@Final boss Veigar has appeared! Defeat him to claim your reward!");
                            for (NPC npc : npcs) {
                                spawnNpc(party, npc);
                            }
                        }

                        tick++;
                    }

                });

                stop();
            }
        });

    }

    public static void spawnNpc(ZombieRaidsParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(ZombieRaidsParty party, Player player) {
        party.getPlayers().remove(player);
        party.remove(player, true);
        player.sendMessage("@red@You died and were removed from the raid party.");
    }

    public static Player randomPlayer(ZombieRaidsParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(ZombieRaidsParty party) {
        party.enteredDungeon(false);

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
        }

        TaskManager.submit(new Task(3, false) {

            @Override
            public void execute() {
                party.sendMessage("@red@Your party has completed the League of Legends Raids!");

                for (Player player : party.getPlayers()) {

                    player.getInventory().add(18404, 1);
                    player.getSeasonPass().addXp(2);
                    player.getAchievementTracker().progress(AchievementData.RAIDER, 1);
                    player.getPointsHandler().incrementZombieRaidKC(1);
                    party.moveTo(ZombieRaidData.lobbyPosition);
                    player.getRaidsParty().enteredDungeon(false);
                    party.setDeathCount(0);
                    party.setKills(0);
                    party.setCurrentPhase(1);


                    if (player.getRaidsParty() != null) {
                        player.getRaidsParty().remove(player, true);
                        player.sendMessage("You left your Raids party.");
                    }
                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_RAIDS) {
                        if (player.getInventory().getFreeSlots() > 0) {
                            player.getInventory().add(18404, 1);
                        } else {
                            player.getBank(0).add(18404, 1);
                        }
                        player.sendMessage("<col=005fbe>You received x2 loot whilst X2 Raids Perk is active!");
                    }
                    Cases.grantCasket(player, 10);
                }
                party.getPlayers().clear();
                stop();
            }
        });

    }

    public static Box getLoot(Box[] loot, int size) {

        Box[] possibleDrops = new Box[loot.length];
        int possibleDropsCount = 0;
        for (Box drop : loot) {
            if (Misc.getRandom(100 * size) <= drop.getRate()) {
                possibleDrops[possibleDropsCount++] = drop;
            }
        }

        if (possibleDropsCount > 0) {
            return possibleDrops[Misc.getRandom((possibleDropsCount - 1))];
        } else {
            return loot[Misc.getRandom((possibleDropsCount - 1))];
        }
    }

    public static void destroyInstance(ZombieRaidsParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredZombieRaids(false);
        }
        party.moveTo(ZombieRaidData.lobbyPosition);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}