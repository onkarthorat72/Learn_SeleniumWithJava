// Define the package for the Selenium test
package Selenium_BasicsCommands;

// Import necessary libraries
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Define the Selenium test class
public class Selenium_10_Demo {

    // 1. Define the test method to verify VWO login
    @Test(groups = "QA")
    @Description("Verify the current URL, title of VWO app")
    public void testVWOLogin() {

        // 2. Create a new instance of EdgeDriver
        WebDriver driver = new EdgeDriver();

        // 3. Maximize the browser window
        driver.manage().window().maximize();

        // 4. Open the VWO application URL
        driver.get("https://app.vwo.com");

        // 5. Print the title of the page
        System.out.println(driver.getTitle());

        // 6. Verify that the title of the page is "Login - VWO"
        Assert.assertEquals(driver.getTitle(), "Login - VWO");

        // 7. Verify that the current URL is "https://app.vwo.com/#/login"
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
    }
}
