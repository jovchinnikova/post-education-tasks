package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MyAbstractPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAbstractPage.class);

    public MyAbstractPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder=\"Искать на Ozon\"]")
    private WebElement searchBar;

    @FindBy(css = "form[action=\"/search\"]>button")
    private ExtendedWebElement searchButton;

    @FindBy(css = "span[class=\"f-caption--bold ub8\"]")
    private ExtendedWebElement cartAdded;

    private final By inputText = By.cssSelector("input[class=\"ui-g1 ui-g4\"]+p");

    public SearchResultsPage search(String searchText) {
        searchBar.sendKeys(searchText);
        searchButton.click();
        String url = driver.getCurrentUrl();
        return new SearchResultsPage(driver, url);
    }

    public void chooseLocation(String location) {
        LocationBlock locationBlock = new LocationBlock(getDriver());
        locationBlock.getLocationButton().click();
        locationBlock.getLocationInput().sendKeys(location);

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(inputText, "Ваш город ..."));

        List<WebElement> locations = locationBlock.getLocations();

        if (locations != null) {
            locations.stream()
                    .map(loc -> loc.getText())
                    .forEach(loc -> LOGGER.info(loc));

        } else throw new RuntimeException("No results for your location");
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public ExtendedWebElement getCartAdded() {
        return cartAdded;
    }

    public By getInputText() {
        return inputText;
    }
}
