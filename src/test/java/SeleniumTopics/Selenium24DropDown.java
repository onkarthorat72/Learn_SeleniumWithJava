package SeleniumTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium24DropDown {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver= new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Select drop own menu, use by 'Select' class")
    public void testPositive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement element_Select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_Select);

        //select.selectByIndex(0); // Disable -?  Negative -
        //select.selectByIndex(1);

        select.selectByVisibleText("Option 2");

        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
