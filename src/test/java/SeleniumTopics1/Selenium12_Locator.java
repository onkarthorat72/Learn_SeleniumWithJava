package SeleniumTopics1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates the usage of locators in Selenium WebDriver
 * to find web elements and perform actions on them.
 */
public class Selenium12_Locator {

    /**
     * This test case finds elements and attempts to log in with invalid credentials.
     * It then verifies the error message displayed on the page.
     */
    @Test(groups = "QA")
    @Description("Find elements and login with invalid credentials")
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("pass123");
        driver.findElement(By.id("js-login-btn")).click();

        try {
            // Wait for 3 seconds (not recommended in production code)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Find the error message element
        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));

        // Get the text of the error message element
        String error_msg_text = error_msg.getText();

        // Assert that the error message text matches the expected value
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");

        // Close the browser
        driver.quit();
    }
}