package SeleniumTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium20Alert {


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
     * This is a test case that navigates to a website and clicks on the "Use Current Location" button.
     * It performs the following steps:
     * 1. Navigate to the "https://wf-ecomm-pwa-git-feat-enhanced-search-wellness-forever.vercel.app/" website.
     * 2. Maximize the browser window.
     * 3. Wait for 3 seconds (this is a static wait and should be avoided in production code).
     * 4. Find the "Use Current Location" button element using an XPath locator.
     * 5. Click on the "Use Current Location" button.
     * 6. Wait for 5 seconds (this is a static wait and should be avoided in production code).
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://wf-ecomm-pwa-git-feat-enhanced-search-wellness-forever.vercel.app/");
        driver.manage().window().maximize();

        Thread.sleep(3000); // Static wait, should be avoided in production code
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Use Current Location')]"));
        element.click();

        // Waits
        Thread.sleep(5000); // Static wait, should be avoided in production code
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


