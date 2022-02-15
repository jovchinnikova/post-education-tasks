package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(css = "div.i8h>a>span>span")
    private ExtendedWebElement productTitle;

    @FindBy(css = "div[class=\"hi3 i3h\"] button.ui-b3")
    private ExtendedWebElement toCartButton;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTitle() {
        return productTitle;
    }

    public ExtendedWebElement getToCartButton() {
        return toCartButton;
    }
}
