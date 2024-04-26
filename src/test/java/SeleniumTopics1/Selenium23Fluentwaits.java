package SeleniumTopics1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium23Fluentwaits {

    EdgeDriver driver; // Declaring EdgeDriver instance

    @BeforeTest
    public void openBrowser() {
        // Creating EdgeOptions object for browser settings
        EdgeOptions options = new EdgeOptions();

        // Setting page load strategy to normal
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Initializing EdgeDriver with options
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description") // Adding description for test case
    public void testPositive() throws InterruptedException {

        driver.get("https://app.vwo.com"); // Navigating to VWO login page
        driver.manage().window().maximize(); // Maximizing the browser window

        // Entering login credentials
        driver.findElement(By.id("login-username")).sendKeys("contact+atb5x@thetestingacademy.com");
        driver.findElement(By.id("login-password")).sendKeys("ATBx@1234");

        driver.findElement(By.id("js-login-btn")).click(); // Clicking on the login button

        // Implementing Fluent Wait to wait for the logged-in username element
        Wait<EdgeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Setting maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Setting polling interval
                .ignoring(NoSuchElementException.class); // Ignoring NoSuchElementException

        // Waiting until the logged-in username element is visible
        WebElement loggein_userName = wait.until(driver->driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));

        // Printing the logged-in user details
        System.out.println("Logged in User details -> " + loggein_userName.getText());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit(); // Closing the browser after test execution
    }
}
