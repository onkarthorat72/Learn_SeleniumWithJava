package SeleniumTopics1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium15Xpath {

    //Positive Scenario
    // Types of Locators
    // 1. ID, ClassName, Name, byTag F(n) -> GetText and GetAttribute (Elements)
    // 2. LinkText & Partial Text
    // 3. Css Selectors
    // 4. Xpath

    /**
     * This test case verifies the current URL, title of the VWO app,
     * and prints the text of all anchor (<a>) tags on the page.
     */
    @Test(groups = "QA")
    @Description("Verify the current URL, title of VWO app")
    public void tagName() {
        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the VWO app
        driver.get("https://app.vwo.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Find all the anchor (<a>) tags on the page
        List<WebElement> all_a_tags = driver.findElements(By.tagName("a"));

        // Get the number of anchor tags
        int tagCount = all_a_tags.size();
        System.out.println("Number of anchor tags on the page: " + tagCount);

        // Iterate through the list of anchor tags and print their text
        for (WebElement element : all_a_tags) {
            System.out.println(element.getText());
        }

        // Close the browser
        driver.close();
    }
}

