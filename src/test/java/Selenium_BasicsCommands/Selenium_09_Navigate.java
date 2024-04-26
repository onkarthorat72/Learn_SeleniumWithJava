package Selenium_BasicsCommands;
// Import EdgeDriver class

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium_09_Navigate {

    public static void main(String[] args) throws MalformedURLException {

        // 1. Launch Edge browser
        EdgeDriver driver = new EdgeDriver();

        // 2. Navigate to a URL using driver.get()
        driver.get("https://github.com/onkarthorat72/SeleniumJAVAProject");
        System.out.println(driver.getTitle() + " - via get()"); // Print title

        // 3. Navigate to another URL using navigate().to()
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle() + " - via navigate().to()"); // Print title

        // 4. Navigate using URL object (alternative for navigate().to())
        driver.navigate().to(new URL("https://google.com"));
        System.out.println(driver.getTitle() + "( - via navigate().to(URL) )"); // Print title

        // 5. Navigation history example (not applicable to get())
        driver.navigate().back(); // Go back in browser history (may not work with get())
        driver.navigate().forward(); // Go forward in browser history (may not work with get())
        driver.navigate().refresh(); // Refresh the current page

        // 6. Close the browser
        driver.quit();

    }

}
