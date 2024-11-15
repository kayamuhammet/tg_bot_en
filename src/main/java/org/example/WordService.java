package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Word;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordService {

    private List<Word> wordList;
    private Long chatId;

    public WordService(Config config) throws IOException{
        loadWords();
        this.chatId = config.getChatId();
    }

    private void loadWords() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        wordList = Arrays.asList(objectMapper.readValue(new File("src/main/resources/data/words.json"), Word[].class));
    }

    public void startQuiz(TelegramLongPollingBot bot){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendQuiz(chatId, bot);
            }
        },0, 300000); // 5 dakika bir quiz
    }

    public void sendQuiz(Long chatId, TelegramLongPollingBot bot){
        Random rand = new Random();
        Word word = wordList.get(rand.nextInt(wordList.size()));
        String correctAnswer = word.getDefinition();

        List<String> options = new ArrayList<>();
        options.add(correctAnswer);

        Set<String> definitionsSet = new HashSet<>();
        while (definitionsSet.size() < 3){
            String randomDefinition = wordList.get(rand.nextInt(wordList.size())).getDefinition();
            if(!randomDefinition.equals(correctAnswer)){
                definitionsSet.add(randomDefinition);
            }
        }
        options.addAll(definitionsSet);
        Collections.shuffle(options);

        SendPoll poll = new SendPoll();
        poll.setChatId(chatId);
        poll.setQuestion("Kelime: " + word.getWord());
        poll.setOptions(options);
        poll.setType("quiz");
        poll.setIsAnonymous(true);
        poll.setCorrectOptionId(options.indexOf(correctAnswer));

        try{
            bot.execute(poll);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
