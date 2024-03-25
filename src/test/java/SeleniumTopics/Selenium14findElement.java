package SeleniumTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium14findElement {

    @Test(groups = "QA")
    @Description ("Find Element")

    public static void main(String[] args)  {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebElement full_anchor = driver.findElement(By.linkText("Start a free trial"));//works if the exact match of the text is found
        //WebElement partial_anchor = driver.findElement(By.partialLinkText("Start a free"));//works even if a part of the text is found
        System.out.println(full_anchor.getAttribute("href"));
        full_anchor.click();



        driver.quit();

    }
}
