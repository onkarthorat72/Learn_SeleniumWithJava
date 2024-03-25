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

public class Selenium19UseCSSSelectors {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Demo for use of cssSelector")
    public void testPositive() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']")); // use single cot for the xpath attribute
        searchBox.sendKeys("macmini");

        driver.findElement(By.cssSelector("input[value='Search']")).click();

        //use Wait
        Thread.sleep(3000);
        List<WebElement> searchedTitles = driver.findElements(By.className("s-item__title"));
        int i = 0;
        for (WebElement title : searchedTitles) {
            System.out.println(i + "-> " + title.getText());
            if (i == 10) {
                title.click();
            }
            i++;
        }

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
