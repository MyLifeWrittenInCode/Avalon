package com.ruse.world.content;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class GogetaSystem {
	public static int getLeft() {
		return totalCount - npckills;
		}
	public static final int totalCount = 8000;
	public static int npckills = 0;
	
	public static void commandSpawnBoss() {
		NPC npc = new NPC(187, new Position(3358, 9311));
		World.register(npc);
		World.sendMessage("<img=1354><col=92370f><shad=1>GOKU HAS ARRIVED!@bla@ go kill him before he distorys the planet at@blu@ ::goku@bla@");
		npckills = 0;
	}
	public static void spawnBoss() {
		if(npckills < 8000) {
			return;
		}
		
		NPC npc = new NPC(187, new Position(3358, 9311));
		World.register(npc);
		World.sendMessage("<img=1354><col=92370f><shad=1>GOKU HAS ARRIVED!@bla@ go kill him before he distorys the planet at@blu@ ::goku@bla@");
		npckills = 0;
	}
	public static void callBoss() {
		if(npckills > 1999 && npckills < 2001) {
		World.sendMessage("<shad=1>@or2@We are 25% to spawning goku keep it going!");
		if(npckills > 3999 && npckills < 4001) {
			World.sendMessage("<shad=1>@or2@We are halfway to goku keep it going!");
			if(npckills > 5999 && npckills < 6001) {
				World.sendMessage("<shad=1>@or2@We are halfway to goku keep it going!");
		//World.sendMessage("<img=1354><col=92370f>GOKU HAS ARRIVED!@bla@ go kill him before he distorys the planet at@blu@ ::goku@bla@");

			return;
				}
			}
		}
	}
	
}
