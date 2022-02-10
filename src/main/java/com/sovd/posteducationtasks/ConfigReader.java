package com.sovd.posteducationtasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath is not specified in the config.properties file");
    }

    public String getUrl(){
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url is not specified in the config.properties file");
    }

    public String getExpectedTitle(){
        String expectedTitle = properties.getProperty("expectedTitle");
        if(expectedTitle != null) return expectedTitle;
        else throw new RuntimeException("expectedTitle is not specified in the config.properties file");
    }

}
