package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LocationBlock extends AbstractUIObject {

    public LocationBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "button,span.ui-b4 ui-d7")
    private ExtendedWebElement locationButton;

    @FindBy(css = "input[class=\"ui-g1 ui-g4\"]")
    private WebElement locationInput;

    private final By locCSS = By.cssSelector("ul[class=\"vf1\"]>li>a");

    public ExtendedWebElement getLocationButton() {
        return locationButton;
    }

    public WebElement getLocationInput() {
        return locationInput;
    }

    public List<WebElement> getLocations() {
        return driver.findElements(locCSS);
    }
}
