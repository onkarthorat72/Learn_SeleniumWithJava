package SeleniumTopics0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Selenium_03_AddExtension {

    public static void main(String[] args) {

        // Extension to the Edge Browser
        // YouTube video - Ad Blocker/xpath finder Extension
        // Selenium using

        ChromeOptions options = new ChromeOptions();
        //edgeOptions.addArguments("--headless");

        options.addExtensions(new File
                ("C:\\Users\\Sanjay Thorat\\Downloads\\SelectorsHub.crx"));
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());

        //driver.quit();
    }
}
