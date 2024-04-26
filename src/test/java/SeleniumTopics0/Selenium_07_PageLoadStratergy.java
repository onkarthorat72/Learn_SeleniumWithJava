package SeleniumTopics0;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static java.lang.Thread.sleep;

public class Selenium_07_PageLoadStratergy {
    public static void main(String[] args) throws InterruptedException {

        // 1. Configure Edge Options for Maximized Window and Page Load Strategy
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");  // Maximize browser window
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);  // Wait only for initial HTML content

        // 2. Initialize Edge WebDriver with Options
        WebDriver driver = new EdgeDriver(edgeOptions);

        // 3. Navigate to SDET.live Website
        driver.get("https://sdet.live");

        // 4. (Optional) Print Page Title (Might not be available immediately with NONE strategy)
        try {
            System.out.println(driver.getTitle());  // Attempt to print title, handle potential exception
        } catch (Exception e) {
            System.out.println("Page title might not be available yet due to NONE strategy.");
        }

        // 5. Introduce a Pause (Not ideal for automation, use explicit waits instead)
        sleep(3000);  // Introduce a 3-second wait (consider using explicit waits)

        // 6. Close the Browser
        driver.quit();
    }
}
