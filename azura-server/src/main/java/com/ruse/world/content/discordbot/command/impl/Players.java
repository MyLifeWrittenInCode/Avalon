package com.ruse.world.content.discordbot.command.impl;

import com.ruse.GameSettings;
import com.ruse.world.World;
import com.ruse.world.content.GlobalBoss1;
import com.ruse.world.content.GlobalBoss2;
import com.ruse.world.content.GlobalBoss3;
import com.ruse.world.content.GlobalBoss4;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/*
 * @project Vanity-Server
 * @author Patrity - https://github.com/Patrity
 * Created on - 4/13/2020
 */
public class Players  extends ListenerAdapter {
     
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        int players = GameSettings.players + World.getPlayers().size ();
        eb.setTitle("Server Information");
        eb.setDescription("There are currently " + players + " players online!");
        eb.addField("Global boss status:", GlobalBoss1.currentBoss != null ? "   Alive ": "   Dead", true);
        eb.addField("Global boss status:", GlobalBoss2.currentBoss != null ? "   Alive ": "   Dead", true);
        eb.addField("Global boss status:", GlobalBoss3.currentBoss != null ? "   Alive ": "   Dead", true);
        eb.addField("Global boss status:", GlobalBoss4.currentBoss != null ? "   Alive ": "   Dead", true);
        eb.addField("X2 Drop rate:", GameSettings.DOUBLEDR ? "On " :"Off", true);

        eb.setThumbnail(e.getJDA().getSelfUser().getAvatarUrl());
        eb.setColor(new Color(0x296d98));
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
