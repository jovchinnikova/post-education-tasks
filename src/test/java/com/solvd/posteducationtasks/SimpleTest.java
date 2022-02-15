package com.solvd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.sovd.posteducationtasks.Cart;
import com.sovd.posteducationtasks.HomePage;
import com.sovd.posteducationtasks.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTest implements IAbstractTest {

    private final String searchText = "джинсы";
    private HomePage homePage;

    @Test
    public void verifyHomePageOpenTest(){
        homePage  = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home page wasn't opened");
    }

    @Test
    public void verifySearchResultsTest(){
        homePage = new HomePage(getDriver());
        homePage.open();
        SearchResultsPage searchResultsPage = homePage.search(searchText);
        searchResultsPage.findResults();
    }

    @Test
    public void verifyAddingToCartTest(){
        homePage = new HomePage(getDriver());
        homePage.open();
        SearchResultsPage searchResultsPage = homePage.search(searchText);
        searchResultsPage.addToCart();
        Assert.assertTrue(searchResultsPage.getCartAdded().isElementPresent());
    }

    @Test
    public void verifyDeletingFromCartTest(){
        homePage = new HomePage(getDriver());
        homePage.open();
        SearchResultsPage searchResultsPage = homePage.search(searchText);
        searchResultsPage.addToCart();
        Cart cart = searchResultsPage.goToCart();
        Assert.assertTrue(cart.getOrdersBlock().isUIObjectPresent());
        cart.deleteFromCart();
        Assert.assertTrue(cart.getEmptyCart().isElementPresent());
    }
}
