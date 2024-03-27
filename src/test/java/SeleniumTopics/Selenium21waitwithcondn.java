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

/**
 * This class demonstrates the use of explicit wait with an expected condition
 * in Selenium WebDriver for the Microsoft Edge browser.
 */
public class Selenium21waitwithcondn {

    // Declare an instance variable to store the EdgeDriver instance
    EdgeDriver driver;

    /**
     * This method is executed before running any test cases in the class.
     * It initializes the EdgeDriver instance with the specified options,
     * including setting the page load strategy to NORMAL.
     */
    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    /**
     * This is a test case that demonstrates the use of explicit wait with an expected condition.
     * It performs the following steps:
     * 1. Navigate to the "https://app.vwo.com" website.
     * 2. Maximize the browser window.
     * 3. Enter the login credentials by finding the username and password fields using their IDs and sending the keys.
     * 4. Click the login button by finding the button element using its ID.
     * 5. Find the element representing the error message using its ID.
     * 6. Create a WebDriverWait instance with a timeout of 3000 seconds (approximately 50 minutes).
     * 7. Wait until the text "Your email, password, IP address or location did not match" is present in the error message element.
     * 8. Print the text of the error message element.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
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

        // Finding the element of the error message
        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));

        // Using WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        // Wait condition -> ExpectedConditions.textToBePresentInElement
        wait.until(ExpectedConditions.textToBePresentInElement(error_msg, "Your email, password, IP address or location did not match"));

        // Printing the error message
        System.out.println("1 -> " + error_msg.getText());
    }

    /**
     * This method is executed after all test cases in the class have finished running.
     * It calls the quit() method on the driver instance to close the browser and terminate the WebDriver session.
     */
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}