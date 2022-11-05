package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class task6 {
    /*
    TC #6: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }
    @Test
    public void dropdownLink (){
        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        websiteDropdown.click();
        WebElement facebook= driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();
        String expectedResult = "Facebook - log in or sign up";
        String actualResult= driver.getTitle();

        Assert.assertEquals(actualResult,expectedResult);
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
