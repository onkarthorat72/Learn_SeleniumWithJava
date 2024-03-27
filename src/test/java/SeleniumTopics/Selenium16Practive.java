package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium16Practive {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the CURA Healthcare Service website
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Print the title of the current page
        System.out.println(driver.getTitle() + " 1st Page ");

        // Find the "Make Appointment" button and click on it
        WebElement appointment_button = driver.findElement(By.id("btn-make-appointment"));
        appointment_button.click();

        // Wait for 2 seconds (not recommended in production code)
        Thread.sleep(2000);

        // Assert that the current URL is "https://katalon-demo-cura.herokuapp.com/profile.php#login"
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Find the username field and enter "John Doe"
        WebElement userName = driver.findElement(By.id("txt-username"));
        userName.sendKeys("John Doe");

        // Find the password field and enter "ThisIsNotAPassword"
        WebElement passWord = driver.findElement(By.xpath("//input[@id='txt-password']"));
        passWord.sendKeys("ThisIsNotAPassword");

        // Find the login button and click on it
        driver.findElement(By.id("btn-login")).click();

        // Print the title of the current page
        System.out.println(driver.getTitle());

        // Close the browser
        driver.close();
    }
}
