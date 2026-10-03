package org.test.mineGramChat;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class MinecraftChatListener implements Listener {
    MineGramChat mineGramChat = MineGramChat.getInstance();
    @EventHandler
    public void chat(AsyncChatEvent e){
        String plainText = PlainTextComponentSerializer.plainText().serialize(e.message());
        mineGramChat.bot.sendTextMessage(">" + e.getPlayer().getName() + "\n>" + plainText);
    }
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        mineGramChat.bot.sendTextMessage("> " + e.getPlayer().getName() + " зашёл\\(\\-а\\) на сервер\\.");
    }
    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent e){
        mineGramChat.bot.sendTextMessage("> " + e.getPlayer().getName() + " покинул\\(\\-а\\) сервер\\.");
    }
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e){
        mineGramChat.bot.sendTextMessage(">" + e.getPlayer().getName() + " умер\\(\\-ла\\)\\.");
    }
}
