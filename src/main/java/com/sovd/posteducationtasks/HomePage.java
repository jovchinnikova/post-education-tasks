package com.sovd.posteducationtasks;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{

    private final WebDriver driver;

    private final By searchBar = By.cssSelector("[placeholder=\"Искать на Ozon\"]");

    private final By searchButton = By.cssSelector("form[action=\"/search\"]>button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final ConfigReader configReader = new ConfigReader();

    public void openHomePage(){
        driver.get(configReader.getUrl());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SearchResultsPage search(String searchText){
        driver.findElement(searchBar).sendKeys(searchText);
        driver.findElement(searchButton).click();
        String url = driver.getCurrentUrl();
        return new SearchResultsPage(driver,url);
    }
}
