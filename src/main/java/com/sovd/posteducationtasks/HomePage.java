package com.sovd.posteducationtasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage{

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private final WebDriver driver;

    @FindBy(css = "[placeholder=\"Искать на Ozon\"]")
    private WebElement searchBar;

    @FindBy(css = "form[action=\"/search\"]>button")
    private WebElement searchButton;

    @FindBy(css="button,span[class=\"ui-b4 ui-d7\"]")
    private WebElement locationButton;

    @FindBy(css = "input[class=\"ui-g1 ui-g4\"]")
    private WebElement locationInput;

    @FindAll(@FindBy(css = "ul[class=\"f6y\"]>li>a"))
    private List<WebElement> locations;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final ConfigReader configReader = new ConfigReader();

    public void openHomePage(){
        driver.get(configReader.getUrl());
        driver.manage().window().fullscreen();
        PageFactory.initElements(driver,this);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SearchResultsPage search(String searchText){
        searchBar.sendKeys(searchText);
        searchButton.click();
        String url = driver.getCurrentUrl();
        return new SearchResultsPage(driver,url);
    }

    public void chooseLocation(String location){
        locationButton.click();
        locationInput.sendKeys(location);

        if(locations != null) {
            locations.stream()
                    .map(loc -> loc.getText())
                    .forEach(loc -> LOGGER.info(loc));

        } else throw new RuntimeException("No results for your location");

    }
}
