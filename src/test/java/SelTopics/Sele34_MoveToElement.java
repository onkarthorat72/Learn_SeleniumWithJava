package SelTopics;

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

//       driver.findElement(By.xpath(
//                "//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();

        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/label"));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//*[@id=\"react-autowhatever-1\"]"));
//                "//ul[@class=\\\"react-autosuggest__suggestions-list\\\"]/li"));
        for (WebElement e : list_auto_complete) {
            if (e.getText().contains("New Delhi")) {
                e.click();
                break;
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
