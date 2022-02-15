package com.sovd.posteducationtasks;

import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;

public class HomePage extends MyAbstractPage{

    public HomePage(WebDriver driver){
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }
}
