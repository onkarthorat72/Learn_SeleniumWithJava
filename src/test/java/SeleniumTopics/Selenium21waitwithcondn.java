package SeleniumTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium21waitwithcondn {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Global wait to all the elements which we don't use

        driver.findElement(By.id("login-username")).sendKeys("93npu2yyb0@esiix.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");
        driver.findElement(By.id("js-login-btn")).click();

// finding the element of error msg
        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
// using WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
// wait condition -> ExpectedConditions.textToBePresentInElement
        wait.until(ExpectedConditions.textToBePresentInElement(error_msg, "Your email, password, IP address or location did not match"));
// Printing the error msg
        System.out.println("1 -> " + error_msg.getText());


    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

