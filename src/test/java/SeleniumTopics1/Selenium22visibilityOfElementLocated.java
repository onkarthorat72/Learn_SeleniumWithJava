package SeleniumTopics1;

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

public class Selenium22visibilityOfElementLocated {

    EdgeDriver driver; // Declaring EdgeDriver instance

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions(); // Creating EdgeOptions object for browser settings
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Setting page load strategy to normal
        driver = new EdgeDriver(options); // Initializing EdgeDriver with options
    }


    @Test(groups = "QA")
    @Description("Use of Implicit wait, Global wait, Wait with Expected condition and Visibility of cssSelector elements")
    // Adding description for test case
    public void testPositive() {
        driver.get("https://app.vwo.com"); // Navigating to VWO login page
        driver.manage().window().maximize(); // Maximizing the browser window

        // Entering login credentials
        driver.findElement(By.id("login-username")).sendKeys("contact+atb5x@thetestingacademy.com");
        driver.findElement(By.id("login-password")).sendKeys("ATBx@1234");
        driver.findElement(By.id("js-login-btn")).click(); // Clicking on the login button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Creating WebDriverWait with a timeout of 10 seconds

        // Waiting until the element with CSS selector [data-qa='lufexuloga'] is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
        WebElement loggedin_username = driver.findElement(By.cssSelector("[data-qa='lufexuloga']")); // Finding the logged-in user name element

        // Printing the logged-in user details
        System.out.println("Logged in User details -> " + loggedin_username.getText());

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit(); // Closing the browser after test execution
    }

}
