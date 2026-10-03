package org.test.mineGramChat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public final class MineGramChat extends JavaPlugin {
    private static MineGramChat INSTANCE;

    public static MineGramChat getInstance(){
        return INSTANCE;
    }

    public Bot bot;

    private TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        String BOT_TOKEN = getConfig().getString("token");
        INSTANCE = this;
        this.bot = new Bot(BOT_TOKEN);
        Thread.ofVirtual().start(() -> {
            try {
                botsApplication = new TelegramBotsLongPollingApplication();

                botsApplication.registerBot(BOT_TOKEN, bot);

                Bukkit.getLogger().info(
                        "Бот запущен..."
                );

                bot.sendTextMessage("Сервер запущен\\!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        getServer().getPluginManager().registerEvents(new MinecraftChatListener(), this);
    }

    @Override
    public void onDisable() {
        bot.sendTextMessage("Сервер остановлен\\!");
        INSTANCE = null;
        try {
            botsApplication.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
