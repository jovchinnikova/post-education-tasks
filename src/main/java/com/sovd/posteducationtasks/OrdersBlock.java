package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class OrdersBlock extends AbstractUIObject {

    public OrdersBlock(WebDriver driver) {
        super(driver);
    }

    public OrdersBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
