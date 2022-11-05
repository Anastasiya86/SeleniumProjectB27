package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_3 {
//    Verifying “Simple dropdown” and “State selection”
//    dropdown default values
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//            3. Verify “Simple dropdown” default selected value is correct
//    Expected: “Please select an option”
//            4. Verify “State selection” default selected value is correct
//    Expected: “
//    Select a State”

    WebDriver driver;

    @BeforeMethod
    public void settingUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdown(){
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String expectedSimpleDropdown = "Please select an option";
        String actualSimpleDropdown  = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSimpleDropdown,expectedSimpleDropdown,"not applicable");


        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expectedStateDropDown= "Select a State";
        String actualStateDropDown = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateDropDown,expectedStateDropDown);

    }


}
