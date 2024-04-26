package Selenium_BasicsCommands;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium_05_HeadlessOrUIless {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headLess");
        /*
         * 1. headless
         * 2. start max
         * 3. window
         * 4. add extensions
         * 5. 100 of another options - you can use with it
         */

        edgeOptions.addArguments("--start-maximized");

        // edgeOptions.addArguments("--window-size=720,1080");
        //edgeOptions.addArguments("--incognito");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        // Dynamic Dispatch -> Runtime Polymorphism

        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

        driver.navigate().to("https://stackoverflow.com/");
        System.out.println(driver.getTitle());

        //driver.manage().window().maximize(); OLD WAY TO MAXIMIZE THE WINDOW SIZE

        driver.quit();
    }
}
