package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart extends AbstractPage {

    @FindBy(css = "div.s4a")
    private OrdersBlock ordersBlock;

    @FindBy(css = "span[class=\"am0 a0m\"]")
    private ExtendedWebElement deleteSelected;

    @FindBy(css = "div[class=\"an8 ui-b1\"]>button")
    private ExtendedWebElement deleteButton;

    @FindBy(css = "div[data-widget=\"emptyCart\"]")
    private ExtendedWebElement emptyCart;

    @FindBy(css = "div[class=\"ui-h2\"]")
    private Add add;

    public Cart(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("cart_url"));
    }

    public void deleteFromCart(){
        /*WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"ui-h2\"]")));*/
        if(add.isUIObjectPresent()){
            add.getCloseButton().click();
        }
        deleteSelected.click();
        deleteButton.click();
    }

    public OrdersBlock getOrdersBlock() {
        return ordersBlock;
    }

    public ExtendedWebElement getDeleteSelected() {
        return deleteSelected;
    }

    public ExtendedWebElement getDeleteButton() {
        return deleteButton;
    }

    public ExtendedWebElement getEmptyCart() {
        return emptyCart;
    }

    public Add getAdd() {
        return add;
    }
}
