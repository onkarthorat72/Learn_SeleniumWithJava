package SeleniumTopics0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_04_OpenDriver {
    public static void main(String[] args) {

        // If you are using Selenium < 4.6 or selenium 3.14

        // System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
//        // Firefox
//        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
//        // Chrome
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
//        // IE
//        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
//        // Safari
//        System.setProperty("webdriver.safari.driver", "path/to/safaridriver");


        // Selenium 4.x - Selenium Manager - will automatically download the Drivers all
        // when needed when you start the Selenium server.

        WebDriver driver = new EdgeDriver();
        driver.get("https://bing.com");
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://google.com");
        driver1.quit();

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.mozilla.org/en-US/");
        driver2.quit();

//        WebDriver driver3 = new SafariDriver();
//        driver3.get("https://www.apple.com/in/");
//        driver3.quit();

    }
}
