package org.example;
import com.sun.net.httpserver.HttpServer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.net.InetSocketAddress;


public class Main {

    public static void main(String[] args) {
        try {
            Config config = new Config();
            WordService wordService = new WordService(config);
            Bot bot = new Bot(wordService, config.getToken(), config.getUsername());

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);

            wordService.startQuiz(bot);
            startSimpleHttpServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Basit bir HTTP sunucusu başlatır
    private static void startSimpleHttpServer() throws IOException {
        int port = Integer.parseInt(System.getenv("PORT")); // Heroku'dan gelen PORT
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            String response = "Bot is running!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        server.start();
    }

}