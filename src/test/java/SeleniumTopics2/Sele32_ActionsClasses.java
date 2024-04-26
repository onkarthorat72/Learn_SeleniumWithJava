package SeleniumTopics2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sele32_ActionsClasses {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // THETESTINGACADEMY
        // Shift Keydown -> thtestingacademy + Shift KeyUp

        // Entering text in uppercase using Shift key press and release
        WebElement firstName = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName, "The Testing Academy")
                .keyUp(Keys.SHIFT).build().perform();

        // Performing a right-click action on a link
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),\"Click here to Download File\")]"));
        actions.contextClick(link).build().perform();

        Thread.sleep(15000);

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
