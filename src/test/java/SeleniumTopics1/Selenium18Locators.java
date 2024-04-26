package SeleniumTopics1;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium18Locators {
    // This line declares a member variable of type "EdgeDriver" to hold a reference to the Edge browser instance
    EdgeDriver driver;

    // This line marks the following method to run before each test case
    @BeforeTest
    public void openBrowser() {

        driver = new EdgeDriver(); // This line creates a new instance of the Edge browser
        //driver.manage().window().maximize(); // This line (currently commented out) would maximize the browser window
    }

    @Test(groups = "QA") // This line marks the following method as a test case belonging to the "QA" group (optional for organizing tests)
    @Description("Test Case Description (Replace with a more specific description)") // (Optional) This line adds a description to the test case
    public void testPositive() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/"); // This line opens the provided URL in the Edge browser

        // Maximize the browser window (currently commented out)
        //driver.manage().window().maximize();  // You can uncomment this line to maximize the window if needed

        /*
         * This section explains different locator strategies used to find elements on a web page:
         *
         * CSS Selectors:
         *   - Used to target elements based on their HTML structure (tags, IDs, classes, attributes).
         *   - Examples:
         *     - `tagName#id`: Selects an element with a specific tag name and ID (e.g., `p#description`).
         *     - `tagName.className`: Selects an element with a specific tag name and class name (e.g., `button.submit-button`).
         *     - `tagName[attribute=value]`: Selects an element with a specific tag name and attribute that has a particular value (e.g., `input[type="text"]`).
         *
         * XPath:
         *   - A more complex way to locate elements using a path-like expression based on the element's position in the HTML document.
         *   - Examples:
         *     - `//input[@id='login-username']`: Selects the input element with the ID "login-username" anywhere in the document.
         *     - `//input[@data-qa='hocewoqisi']`: Selects the input element with the custom attribute "data-qa" having the value "hocewoqisi".
         *     - `//input[data-qa$='si']`: Selects any input element where the "data-qa" attribute value ends with "si" (e.g., "testsi").
         */

        // This test case currently lacks the actual logic to demonstrate using locators

        // To make this test case more meaningful, you would need to add code that:
        // 1. Selects a specific element on the webpage using either CSS Selectors or XPath.
        // 2. Performs an action on that element, such as entering text, clicking a button, etc.
    }

    @AfterTest // This line marks the following method to run after each test case
    public void closeBrowser() {
        driver.quit(); // This line closes the Edge browser window
    }
}
