package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchResultsPage extends MyAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAbstractPage.class);

    private final String prodTitle = "Джинсы RoxyFoxy";

    @FindBy(css = "div[class=\"ih7 hi8\"]")
    private List<ProductBlock> productBlocks;

    public SearchResultsPage(WebDriver driver,String url){
        super(driver);
        setPageAbsoluteURL(url);
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class=\"ih7 hi8\"]")));
    }

    public void addToCart(){
        productBlocks.stream()
                .filter(productBlock -> prodTitle.equals(productBlock.getProductTitle().getText()))
                .forEach(productBlock -> productBlock.getToCartButton().click());
    }

    public void findResults(){
        productBlocks.stream()
                .map(productBlock-> productBlock.getProductTitle().getText())
                .forEach(title -> LOGGER.info(title));
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public List<ProductBlock> getProductBlocks() {
        return productBlocks;
    }
}
