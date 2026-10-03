package org.test.mineGramChat;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.logging.Level;

public class Bot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    private final String chatId = MineGramChat.getInstance().getConfig().getString("chat_id");

    private final Integer threadId = MineGramChat.getInstance().getConfig().getInt("thread_id");

    public Bot(String botToken) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    public void sendTextMessage(String text) {
        SendMessage message = SendMessage.builder()
                .parseMode("MarkdownV2")
                .chatId(chatId)
                .messageThreadId(threadId)
                .text(text)
                .build();
        try {
            // Выполняем отправку через клиент
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            System.err.println("Ошибка при отправке: " + e.getMessage());
        }
    }

    @Override
    public void consume(Update update) {
        if(update.hasMessage()){
            Message message = update.getMessage();
            if(message.getChatId().toString().equals(chatId) && message.isSuperGroupMessage() && message.getMessageThreadId().equals(threadId)){
                Bukkit.broadcast(MiniMessage.miniMessage().deserialize("<b><gradient:dark_aqua:aqua>Telegram</gradient></b> " + message.getFrom().getFirstName() + " <dark_gray>>></dark_gray> " + message.getText()));
            }
        }
    }
}
