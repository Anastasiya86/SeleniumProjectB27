package com.cydeo.tests.day8_webtable_utilities.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class task1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }
    @Test
    public void order_name_verify_test(){

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”

        WebElement bobMartinName = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        String expected ="Bob Martin";
        String actual =bobMartinName.getText();
        Assert.assertEquals(actual,expected);

        WebElement bobDate= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        String actual1 = bobDate.getText();
        String expected1 = "12/31/2021";
        Assert.assertEquals(actual1,expected1);


        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        // You can also use this xpath:  //td[.='Bob Martin']/../td[5]
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

