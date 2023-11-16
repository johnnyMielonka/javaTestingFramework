package com.automation.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties readProperties(String propertiesFile) {
        Properties properties = new Properties();
        try (InputStream ip = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            if (ip != null) {
                properties.load(ip);
            }
        } catch (IOException e) {
            System.out.printf("Error while loading properties from file %s%n%s", propertiesFile, e);
        }
        return properties;
    }
}
