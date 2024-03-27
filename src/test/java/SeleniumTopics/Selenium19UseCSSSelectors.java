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

import java.util.List;

/**
 * This class demonstrates the use of CSS selectors in Selenium WebDriver
 * for locating and interacting with web elements on the eBay website.
 */
public class Selenium19UseCSSSelectors {

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
     * This is a test case that demonstrates the use of CSS selectors.
     * It performs the following steps:
     * 1. Navigate to the "https://www.ebay.com/" website.
     * 2. Maximize the browser window.
     * 3. Find the search box element using an XPath locator and send the search query "macmini".
     * 4. Find the search button element using a CSS selector and click on it.
     * 5. Wait for 3 seconds (this is a static wait and should be avoided in production code).
     * 6. Find all the search result titles using the class name "s-item__title".
     * 7. Print the text of each search result title.
     * 8. Click on the 11th search result title.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test(groups = "QA")
    @Description("Demo for use of cssSelector")
    public void testPositive() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']")); // use single quotes for the XPath attribute
        searchBox.sendKeys("macmini");

        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // Use Wait
        Thread.sleep(3000); // Static wait, should be avoided in production code

        List<WebElement> searchedTitles = driver.findElements(By.className("s-item__title"));

        //This line initializes a counter variable i to 0.
        int i = 0;
        //This is a loop that iterates over each WebElement in the searchedTitles list.
        for (WebElement title : searchedTitles) {
            System.out.println(i + "-> " + title.getText());//This line prints the index i and the text content of the current search result title (title.getText()).
            if (i == 10) {
                title.click();// This line checks if the index i is equal to 10 (11th search result). If it is, it clicks on the corresponding search result title (title.click()).
            }
            i++;//This line increments the counter variable i by 1 for the next iteration of the loop.

        }
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