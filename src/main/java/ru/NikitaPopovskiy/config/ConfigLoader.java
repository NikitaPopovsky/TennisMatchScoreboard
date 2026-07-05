package ru.NikitaPopovskiy.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream stream = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (stream == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(stream);
        } catch (Exception e) {
            throw new RuntimeException("config.properties parsing error");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
