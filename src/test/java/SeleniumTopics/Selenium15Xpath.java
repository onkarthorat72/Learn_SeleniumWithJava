package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium15Xpath {

    //Positive Scenario
    // Locators
    // 1. ID, ClassName, Name, byTag F(n) -> GetText and GetAttribute (Webelements)

    // 2. LinkText & Partial Text
    // 3.Css Selectors
    // 4. Xpath

//    @Test(groups = "QA")
//    @Description("Verify the current URl, title of VWO app")
public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.get("https://app.vwo.com");
    driver.manage().window().maximize();
    List<WebElement> all_a_tags = driver.findElements(By.tagName("a"));
    all_a_tags.size();
    for (WebElement element : all_a_tags) {
        System.out.println(element.getText());
    }
    //58:41

    driver.close();
}


    }

