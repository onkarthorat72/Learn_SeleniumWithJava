package Selenium_Basics;

import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_08_CloseNQuit {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://github.com/onkarthorat72/SeleniumJAVAProject");


        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

       // driver.close(); // Close the Current Browser Window - not the full browser
       /*Closed the window,
       * Session id != null,
       * Error - Invalid session Id
       */

        driver.quit();
        // Close all the /sessions/windows and stop the browser
        // Closed All the window and Session = null,
        // Error - Session ID is nul
    }
}
