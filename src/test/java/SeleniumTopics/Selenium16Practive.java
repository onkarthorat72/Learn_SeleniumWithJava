package SeleniumTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium16Practive {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle() + " 1st Page ");

        WebElement appointment_button = driver.findElement(By.id("btn-make-appointment"));
        appointment_button.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");


        WebElement userName = driver.findElement(By.id("txt-username"));
        userName.sendKeys("John Doe");


        WebElement passWord = driver.findElement(By.xpath("//input[@id='txt-password']"));
        passWord.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();
        System.out.println(driver.getTitle());

        driver.close();
    }
}
