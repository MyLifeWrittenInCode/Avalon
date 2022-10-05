package com.ruse.world.content;

import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

public class Cases {

    public static void grantCasket(Player player, int chance){
        if (Misc.getRandom(chance) == 0) {
            int random = Misc.getRandom(3);
            if (random == 0) {
                player.getInventory().add(23812, 1);
                player.sendMessage("You received a Money case.");
            }else if (Misc.getRandom(1) == 0) {
                player.getInventory().add(23411, 1);
                player.sendMessage("You received an Seraphic case.");
            }else{
                player.getInventory().add(23412, 1);
                player.sendMessage("You received a Ethereal case.");
            }
        }
    }

}
