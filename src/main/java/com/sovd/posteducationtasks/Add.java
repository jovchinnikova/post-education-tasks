package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Add extends AbstractUIObject {

    @FindBy(css = "div[class=\"ui-h2\"] div.bn6 button")
    private ExtendedWebElement closeButton;

    public Add(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCloseButton() {
        return closeButton;
    }
}
