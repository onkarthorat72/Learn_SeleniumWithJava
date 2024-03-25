package QA;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02 {
    ChromeDriver driver;


    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void openUrl() {
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
