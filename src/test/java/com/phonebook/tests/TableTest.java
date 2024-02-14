package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void findElementInTableTests(){
        // number of rows
        List<WebElement> tr = driver.findElements(By.cssSelector("tr"));
        System.out.println("Rows in table --> " + tr.size());
        System.out.println("**********************");
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
            System.out.println("===========================");
        }

        // number of columns
        List<WebElement> columns = driver.findElements(By.cssSelector("tr th"));
        System.out.println("Columns on table --> " + columns.size());
        System.out.println("---------------------------");

        // print row 2
        List<WebElement> row2 = driver.findElements(By.cssSelector("#customers tr:nth-child(2) td"));
        for (WebElement element: row2 ) {
            System.out.println(element.getText());
            System.out.println("+++++++++++++++++++++++");
        }

        // print last column
        List<WebElement> lastColumns = driver.findElements(By.cssSelector("tr td:last-child"));
        for (WebElement el :
                lastColumns) {
            System.out.println(el.getText());
            System.out.println("----------------------");
        }

        // print column , row 4
        System.out.println(driver.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(3)")).getText());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
