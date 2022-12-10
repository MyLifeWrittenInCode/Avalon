package com.ruse.world.content.aoe;

import com.ruse.model.CombatIcon;
import com.ruse.model.Hit;
import com.ruse.model.Hitmask;
import com.ruse.model.Locations;
import com.ruse.util.RandomUtility;
import com.ruse.world.clip.region.RegionClipping;
import com.ruse.world.content.combat.Maxhits;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.Iterator;

import static com.ruse.world.content.combat.CombatFactory.npcsDeathDartDontWork;
import static com.ruse.world.content.combat.CombatType.RANGED;

/**
 * 861 100 3000 15 Range

 861 = Item ID
 100 = Minimum damage
 3000 = maximum damage
 15 = radius
 Range = Weapon combat icon that it'll show.
 * @author HP Laptop
 *
 */
public class AOEHandler {

	public static void handleAttack(Character attacker, Character victim, int minimumDamage, int maximumDamage,
									int radius, CombatIcon combatIcon) {

		// if no radius, loc isn't multi, stops.
		if (radius == 0 || !Locations.Location.inMulti(victim)) {
			// System.out.println("Radius 0");
			return;
		}

		// We passed the checks, so now we do multiple target stuff.
		Iterator<? extends Character> it;
		if (attacker.isPlayer() && victim.isPlayer()) {
			it = ((Player) attacker).getLocalPlayers().iterator();
		} else if (attacker.isPlayer() && victim.isNpc()) {
			it = ((Player) attacker).getLocalNpcs().iterator();

			for (Iterator<? extends Character> $it = it; $it.hasNext();) {
				Character next = $it.next ();

				if (next == null || next.equals (attacker) || next.equals (victim) || next.getConstitution () <= 0) {
					continue;
				}

				if (next.isNpc ()) {
					NPC n = (NPC) next;
					if (!n.getDefinition ().isAttackable () || n.isSummoningNpc () || n.getId () == 9897 || n.getId () == 9899) {
						continue;
					}
				} else {
					Player p = (Player) next;
					if (p.getLocation () != Locations.Location.WILDERNESS || !Locations.Location.inMulti (p)) {
						continue;
					}
				}

				if (!next.getPosition ().isWithinDistance (victim.getPosition (), radius) || !RegionClipping.canProjectileAttack (attacker, next)) {
					continue;
				}

				int maxhit = maximumDamage;
				switch (((Player) attacker).getLastCombatType ()) {
					case MELEE:
						maxhit = Maxhits.melee (attacker, victim) / RandomUtility.inclusiveRandom (1, 5);
						break;
					case RANGED:
						maxhit = Maxhits.ranged (attacker, victim) / RandomUtility.inclusiveRandom (1, 5);
						break;
					case MAGIC:
						maxhit = Maxhits.magic (attacker, victim) / RandomUtility.inclusiveRandom (1, 5);
						break;
				}
				Player player = (Player) attacker;
				if (player.getEquipment ().contains (22006) && player.getLastCombatType () == RANGED) {
					NPC npc = (NPC) victim;
					if (!npcsDeathDartDontWork (npc)) {
						maxhit = victim.getConstitution ();
					} else {
						player.sendMessage ("The Death-touch dart didn't work on this.");
					}
				}
				next.dealDamage (new Hit (maxhit, Hitmask.RED, combatIcon));
				next.getCombatBuilder ().addDamage (attacker, maxhit);
				next.getCombatBuilder ().attack (attacker);
			}
		}

	}
}