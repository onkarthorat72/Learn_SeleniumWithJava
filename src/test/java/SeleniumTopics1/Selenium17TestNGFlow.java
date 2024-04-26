// Package declaration
package SeleniumTopics1;

// Import required classes and libraries
import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class demonstrates the basic flow of TestNG and the usage of annotations
 * for test setup, test execution, and test teardown.
 */
public class Selenium17TestNGFlow {

    // Declare an instance variable to store the EdgeDriver instance
    EdgeDriver driver;

    /**
     * This method is executed before running any test cases in the class.
     * It initializes the EdgeDriver instance and creates a new browser session.
     */
    @BeforeTest
    public void openBrowser() {
        // Create Session via the API and Session ID is generated
        driver = new EdgeDriver();
    }

    /**
     * This is a test case that navigates to the CURA Healthcare Service website.
     * It performs the following steps:
     * 1. Navigate to the "https://katalon-demo-cura.herokuapp.com/" website.
     * 2. Maximize the browser window.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVWOLogin_positive() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
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