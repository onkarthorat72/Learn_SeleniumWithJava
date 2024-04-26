package SeleniumTopics1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Selenium13_1AnchorTag {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        // 1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");
        // Question - Print all the anchor Tags on this vwo.com
        // a tags and print the getText
        List<WebElement> all_atags = driver.findElements(By.tagName("a"));
        all_atags.get(0).click(); // start free trial
        all_atags.get(1).click(); // 2nd one - vwo insights
        all_atags.size(); // 2
        for( WebElement element: all_atags){
            System.out.println(element.getText());
        }


        driver.close(); // Close the current window


    }
}