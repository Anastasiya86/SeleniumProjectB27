package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class task3_4 {
    /*
    TC#3: Verifying “Simple dropdown” and “State selection”
dropdown default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test (priority=1)
    public void simpleDropdown(){
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
//        System.out.println("simpleDropdown.getFirstSelectedOption().getText() = " + simpleDropdown.getFirstSelectedOption().getText());
        String expectedSimple = "Please select an option";
        String actualSimple = simpleDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSimple,expectedSimple);
    }
    @Test (priority =2)
    public void stateDropdown(){
        Select stateDropDwn = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropDwn.selectByVisibleText("Illinois");
        stateDropDwn.selectByValue("VA");
        stateDropDwn.selectByIndex(5);
      String finalSelection =  stateDropDwn.getFirstSelectedOption().getText();
      String expectedSelection = "California";
      Assert.assertEquals(finalSelection,expectedSelection);

    }

     @AfterMethod
     public void tearDown(){
         //   driver.quit();
    }






}
