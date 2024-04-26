package SelTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sele37_DragAndDrop {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        //actions.dragAndDrop(from,to).perform();

        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

        Thread.sleep(5000);


//         Download File
//         Checked by the ChromeOption
//         Problem - Download a file and check in the dir if that is present.
//         ChromeOptions -> dir(Doc)
//         filename.doc ->  /User/pramod/Download/chrome
//         file exist - T

        String fileUploadURL = "https://awesomeqa.com/selenium/upload.html";

        driver.get(fileUploadURL);

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        uploadFileInput.click();
        Thread.sleep(2000);
//        uploadFileInput.click();

        // Get the current working directory for file path
        String currentDir = System.getProperty("D:\\Onkar\\TheTestingAcademy\\JAVA Programs and Notes\\Learn_SeleniumWithJava");
        System.out.println("Current directory: " + currentDir);

        // Construct the full path to the upload file (replace "toupload.text" with your actual file name)
        String uploadFilePath = currentDir + "\\src\\test\\java\\SelTopics\\SampleforTest.png";
        //"D:\Onkar\TheTestingAcademy\JAVA Programs and Notes\Learn_SeleniumWithJava\src\test\java\SelTopics\SampleforTest.png"
        uploadFileInput.sendKeys(uploadFilePath);
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
