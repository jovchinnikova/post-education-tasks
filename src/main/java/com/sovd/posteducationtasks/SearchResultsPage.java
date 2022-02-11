package com.sovd.posteducationtasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchResultsPage {

    @FindAll(@FindBy(css = "div.m1h>a>span>span"))
    private List<WebElement> titles;

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver,String url){
        this.driver = driver;
        driver.get(url);
        driver.manage().window().fullscreen();
        PageFactory.initElements(driver,this);
    }

    public List<String> findResults(){
        return titles.stream()
                .map(title-> title.toString().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }
}
