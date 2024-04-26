package SeleniumTopics2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Sele30_SvgHandle {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        // Set up EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest"); // Add guest mode argument

        driver = new EdgeDriver(options); // Initialize EdgeDriver with options
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL); // Open URL
        driver.manage().window().maximize();

        // Find all states using the provided XPath
        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        // Iterate through the states to find Tripura and click on it
        for (WebElement state : states) {
            // Check if the state's aria-label attribute contains "Tripura"
            if (state.getAttribute("aria-label").contains("Tripura")) {
                // Scroll to the state if needed (optional)
                //state.getLocationOnScreenOnceScrolledIntoView();
                // Click on the state
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"notice_policy\"]/div[2]/input")).click();
                state.click();
                // Break the loop once Tripura is found and clicked
                break;
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit(); // Close the browser after test execution
    }
}
