package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium_03_AddExtension {

    @Test
    public void testMethod(){
        //Extension to the Edge Browser
        // YouTube video - Ad Blocker Extension
        //Selenium using

        EdgeOptions edgeOptions = new EdgeOptions();
    //edgeOptions.addArguments("--headless");

        edgeOptions.addExtensions(new File("C:/Users/Sanjay Thorat/Downloads/AdBlocker.com"));
        WebDriver driver  = new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
