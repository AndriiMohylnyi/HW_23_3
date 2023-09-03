package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FirstPropertiesReader {
    private static FirstPropertiesReader instance;
    private Properties properties;

    FirstPropertiesReader() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("src/main/resources/app.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FirstPropertiesReader getInstance() {
        if (instance == null) {
            instance = new FirstPropertiesReader();
        }
        return instance;
    }

    public String getProperties(String name) {
        return properties.getProperty(name);
    }
}
