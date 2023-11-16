package com.automation.helpers;

public class ServiceUrlProvider {

    public static String getServiceUrl() {return EnvPropertiesLoader.getProperties().getProperty("ServiceUrl");}
    public static String getEndpointUrl(){return EnvPropertiesLoader.getProperties().getProperty("EndpointUrl");}
}
