package SeleniumTopics1;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium25JavaScriptAlerts {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("1. Use of Alert class" +
            "2. Clicking on different type of JSAlert and get result")

    public void testPositive() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // //button[text()="Click for JS Alert"]  //  example of finding button by text
        // //button[@onclick='jsAlert()']       //  example of finding button by attribute

        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")); // Finds the button for JS Prompt

        elementPrompt.click(); // Clicks the button to trigger the prompt

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Creates a WebDriverWait object
        wait.until(ExpectedConditions.alertIsPresent()); // Waits for the alert to appear (up to 3 seconds)

        Alert alert = driver.switchTo().alert(); // Switches focus to the alert
        alert.sendKeys("Onkar The Automation Testing Learner"); // Enters text into the prompt

        alert.accept(); // Accepts the prompt (clicks "OK")

        // OR we can cancel By using
        // alert.dismiss(); - option to dismiss the prompt (clicks "Cancel")

        String result = driver.findElement(By.id("result")).getText(); // Gets the text displayed after handling the prompt
        Assert.assertEquals(result, "You Entered: Onkar The Automation Testing Learner"); // Verifies the expected result
        System.out.println(result); // Prints the result for additional logging (optional)
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}