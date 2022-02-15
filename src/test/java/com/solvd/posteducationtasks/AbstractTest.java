package com.solvd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.sovd.posteducationtasks.HomePage;
import org.testng.annotations.Test;

public class AbstractTest implements IAbstractTest {

    private HomePage homePage;
    private final String location = "Москва";

    @Test
    public void chooseLocationTest(){
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.chooseLocation(location);
    }
}
