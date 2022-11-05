package com.cydeo.tests.day7_windows_webtables.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Table_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Set up browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/tables");
    }

    @Test
    public void testWebTables(){
//        P1_ WRITE A LOCATOR THAT RETURNS THE TABLE 1 ITSELF
//
       WebElement webTable= driver.findElement(By.xpath("//table[@id='table1']"));

        //table[@id='table1']
//
//
//        P2_ WRITE A LOCATOR THAT RETURNS ALL OF THE ROWS INSIDE OF TABLE 1
//
//        //table[@id='table1']//tr
//
//
//        P3_ WRITE A LOCATOR THAT RETURNS ALL OF THE ROWS INSIDE OF BODY - TABLE 1
//
//        //table[@id='table1']/tbody//tr
//
//
//        P4_ WRITE A LOCATOR THAT RETURNS ONLY 3RD ROW IN THE BODY
//
//        //table[@id='table1']/tbody//tr[3]
//
//
//        P5_ WRITE A LOCATOR THAT RETURNS ALL OF THE CELLS IN ALL OF THE ROW (IN BODY)
//
//        //table[@id='table1']/tbody//tr//td
//
//
//        P6_ WRITE A LOCATOR THAT RETURNS ALL OF THE FIRST NAMES FROM TABLE
//
//        //table[@id='table1']/tbody//tr//td[2]
//
//        //td[2] --> get me the second cells from all rows
//
//
//        P7_ WRITE A LOCATOR THAT RETURNS FRANKS CELL SPECIFICALLY
//
//        //table[@id='table1']/tbody//tr[2]//td[2]
//
//        //tr[2] --> get me the second row from table in tbody
//        //td[2] --> get me the second cells from second row
//
//
//        P8_ WRITE A LOCATOR THAT RETURNS FRANKS CELL SPECIFICALLY USE FRANKS TEXT
//
//        //table[@id='table1']//td[.='Frank']
//
//
//        P9_ WRITE A LOCATOR THAT RETURNS $100 CELL SPECIFICALLY USE JASON TEXT
//
//        //table[@id='table1']//td[.='Jason']/following-sibling::td[2]
//
//
//
//        P10_ WRITE A LOCATOR THAT RETURNS Tim's last name  BASED ON tim's NAME
        WebElement lastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/preceding-sibling::td[1]"));
        System.out.println("lastName.getText() = " + lastName.getText());
//
//
//
//        P11_ WRITE A LOCATOR THAT RETURNS ALL EMAILS THAT HAS $50 DUE DATE



    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
