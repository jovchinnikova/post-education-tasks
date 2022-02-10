import com.sovd.posteducationtasks.ConfigReader;
import com.sovd.posteducationtasks.HomePage;
import com.sovd.posteducationtasks.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest {

    private WebDriver driver;
    private ConfigReader configReader;
    private final String searchText = "джинсы";
    private HomePage homePage;

    @BeforeTest
    public void setDriver(){
        configReader = new ConfigReader();
        String driverPath = configReader.getDriverPath();
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void verifyHomePageOpenTest(){
        homePage  = new HomePage(driver);
        homePage.openHomePage();
        String title = driver.getTitle();
        String expectedTitle = configReader.getExpectedTitle();
        Assert.assertTrue(title != null && title.contains(expectedTitle),"Home page wasn't opened");
    }

    @Test
    public void verifySearchResultsTest(){
        homePage = new HomePage(driver);
        homePage.openHomePage();
        SearchResultsPage searchResultsPage = homePage.search(searchText);
        List<String> titles = searchResultsPage.findResults();
        SoftAssert softAssert = new SoftAssert();
        titles.stream()
                        .forEach(title -> softAssert.assertTrue(title.contains(searchText)));
        softAssert.assertAll();
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
