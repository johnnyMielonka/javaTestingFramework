package com.automation.helpers;

public class EnvPropertiesProvider {
    public static String getBrowser() {
        return EnvPropertiesLoader.getProperties().getProperty("Browser");
    }
}
