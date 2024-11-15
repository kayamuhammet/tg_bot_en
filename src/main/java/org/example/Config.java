package org.example;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();

    public Config() throws IOException{
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    }

    public String getToken(){
        return properties.getProperty("bot.token");
    }

    public String getUsername(){
        return properties.getProperty("bot.username");
    }

    public Long getChatId() {
        return Long.parseLong(properties.getProperty("bot.chat_id"));
    }
}
