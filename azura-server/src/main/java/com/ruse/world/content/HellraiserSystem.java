package com.ruse.world.content;
import com.ruse.model.Position;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class HellraiserSystem {
	public static int getLeft() {
		return totalCount - npckills;
		}
	public static final int totalCount = 8000;
	public static int npckills = 0;
	
	public static void commandSpawnBoss() {
		NPC npc = new NPC(187, new Position(3100, 5536));
		World.register(npc);
		World.sendMessage("Hellraiser has Arrived! fight him now at ::hellraiser");
		DiscordMessager.sendGogetaBossLog("Hellraiser has appeared ! Join in game and Defeat him before it's too late!");
		npckills = 0;
	}
	public static void spawnBoss() {
		if(npckills < 8000) {
			return;
		}

		NPC npc = new NPC(187, new Position(3100, 5536));
		World.register(npc);
		World.sendMessage("Hellraiser has Arrived! fight him now at ::hellraiser");
		DiscordMessager.sendGogetaBossLog("Hellraiser has appeared ! Join in game and Defeat him before it's too late!");
		npckills = 0;
	}
	public static void callBoss() {
		if(npckills > 1999 && npckills < 2001) {
		World.sendMessage("<shad=1>@or2@We are 25% to spawning Hellraiser keep it going!");
		if(npckills > 3999 && npckills < 4001) {
			World.sendMessage("<shad=1>@or2@We are halfway to Hellraiser keep it going!");
			if(npckills > 5999 && npckills < 6001) {
				World.sendMessage("<shad=1>@or2@We are halfway to Hellraiser keep it going!");
			return;
				}
			}
		}
	}
	
}
