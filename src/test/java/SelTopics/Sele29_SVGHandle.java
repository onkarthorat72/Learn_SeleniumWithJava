package SelTopics;

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

public class Sele29_SVGHandle {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Set page load strategy
        options.addArguments("--guest"); // Add argument for guest mode
        driver = new EdgeDriver(options); // Initialize EdgeDriver with options
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() {
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Nubia");

        // https://www.flipkart.com/
        // //*[local-name()='svg']/*[local-name()='path']
        // (//*[local-name()='svg'])[1]
        // (//*[name()='svg'])[1]


        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));

        svgElements.get(0).click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
