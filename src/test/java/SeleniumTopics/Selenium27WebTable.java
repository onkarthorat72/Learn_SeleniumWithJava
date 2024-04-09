package SeleniumTopics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium27WebTable {


    EdgeDriver driver;

    @BeforeTest
    public void openBrowesr() {

        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test
    @Description("Selenium tutorial for search and find the name from table")
    public void webTable() {
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // table[@id="customers"]/tbody/tr[5]/td[2] - Halen bennet

        // /following-sibling::td - Country

        // Print all the data in the table and if name Halen = country she belongs too


        // xpath ->  //table[@id="customers"]/tbody/tr[5]/td[2]

        //xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]
        // String first_part = "//table[@id=\"customers\"]tbody/tr[";

        // Defining the XPath expressions for the table rows and columns
        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        // Getting the number of rows and columns in the table
        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        // Iterating through the table rows and columns
        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part; // Constructing the dynamic XPath
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText(); // Getting the data from the cell
                System.out.println(data); // Printing the data

                // Checking if the data contains "Helen Bennett"
                if (data.contains("Helen Bennett")) {
                    String country_path = dynamic_xpath + "/following-sibling::td"; // Constructing the XPath for the country column
                    String country_text = driver.findElement(By.xpath(country_path)).getText(); // Getting the country text
                    System.out.println("------>"); // Printing a separator
                    System.out.println("Helen Bennett is in - " + country_text); // Printing the country for Helen Bennett
                }
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
