package SeleniumTopics2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Sele34_MoveToElement {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(5000);

// driver.findElement(By.xpath(
// "//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();

        // Locating the 'From' city input field
        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/label"));
        Thread.sleep(5000); // Waiting for 5 seconds for the city field to be clickable

        // Creating an Actions object to perform mouse actions
        Actions actions = new Actions(driver);
        // Moving the mouse cursor to the 'From' city input field, clicking on it, and sending keys "New Delhi"
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        // Finding all auto-complete suggestions for the city input field
        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//*[@id=\"react-autowhatever-1\"]"));
//  "//ul[@class=\\\"react-autosuggest__suggestions-list\\\"]/li"));

        // Iterating through the list of auto-complete suggestions
        for (WebElement e : list_auto_complete) {
            // Checking if the suggestion contains "New Delhi"
            if (e.getText().contains("New Delhi")) {
                // Clicking on the suggestion if it matches "New Delhi"
                e.click();
            }
        }
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}
