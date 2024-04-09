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

public class Selenium26Checkbox {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("How to click on CheckBox")
    public void checkBox() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Finding all checkbox elements using XPath
        List<WebElement> checkboxes = driver.findElements(By.
                xpath("//input[@type=\"checkbox\"]"));

        // Getting the first checkbox element
        WebElement ch1 = checkboxes.get(0);

        // Clicking on the first checkbox twice (toggle behavior)
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }
}
