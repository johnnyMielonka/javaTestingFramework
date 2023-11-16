package com.automation.helpers;

import java.util.Properties;

/*
Class reads property values from <testEnv>.properties file in src/test/resources.
Desired environment is given as a runtime parameter: mvn -DtestEnv=env.
If no parameter is given , default value is test.
 */
public class EnvPropertiesLoader {
    private static final String ENV = System.getProperty("testEnv","test");
    private static Properties properties;

    public static Properties getProperties(){
        if (properties== null){
            properties = PropertiesLoader.readProperties(ENV+".properties");
        }
        return properties;
    }
}
