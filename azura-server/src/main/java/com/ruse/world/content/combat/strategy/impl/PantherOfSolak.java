package com.ruse.world.content.combat.strategy.impl;

import com.ruse.model.Animation;
import com.ruse.model.Projectile;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class PantherOfSolak implements CombatStrategy {

    private boolean[] specialAttacks = new boolean[3];
    @Override
    public boolean canAttack(Character entity, Character victim) {
        return true;
    }

    @Override
    public CombatContainer attack(Character entity, Character victim) {
        return null;
    }

    @Override
    public boolean customContainerAttack(Character entity, Character victim) {
        NPC panther = (NPC)entity;
        if(panther.isChargingAttack() || victim.getConstitution() <= 0) {
            return true;
        }

        double total = (double) panther.getConstitution() / (double) panther.getDefaultConstitution() * 100;
        if(total <= 75 && !specialAttacks[0]) {
            specialAttacks[0] = true;
        } else if(total <= 50 && !specialAttacks[1]) {
            specialAttacks[1] = true;
        } else if(total <= 25 && !specialAttacks[2]) {
            specialAttacks[2] = true;
        }
        regularAttack(victim, panther);
        return true;
    }



    public void regularAttack(Character victim, NPC tekton) {
        //tekton.setChargingAttack(false).getCombatBuilder().setAttackTimer(attackDelay(tekton) - 2);
        tekton.performAnimation(new Animation(tekton.getDefinition().getAttackAnimation()));
        for (Player p : Misc.getCombinedPlayerList((Player) victim)) {
            if (p != null) {
                boolean mage = Misc.getRandom(10) <= 7;
                new Projectile(tekton, p, mage ? 1658 : 1017, 44, 3, 43, 43, 0).sendProjectile();
                tekton.getCombatBuilder().setContainer(new CombatContainer(tekton, p, 1, mage ? 3 : 2,
                        mage ? CombatType.MAGIC : CombatType.RANGED, true));
            }
        }
    }

    @Override
    public int attackDelay(Character entity) {
        return entity.getAttackSpeed();
    }

    @Override
    public int attackDistance(Character entity) {
        return 50;
    }

    @Override
    public CombatType getCombatType() {
        return CombatType.MIXED;
    }
}
