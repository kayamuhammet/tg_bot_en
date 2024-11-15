package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    private final WordService wordService;
    private final String token;
    private final String username;


    public Bot(WordService wordService, String token, String username){
        this.wordService = wordService;
        this.token = token;
        this.username = username;
    }

    @Override
    public String getBotToken(){
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().getText().equalsIgnoreCase("start")){
            wordService.sendQuiz(update.getMessage().getChatId(), this);
        }
    }


}
