package SeleniumTopics2;

import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sele36_PageUp_Down {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Page Scroll Down");

    }

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }

}
