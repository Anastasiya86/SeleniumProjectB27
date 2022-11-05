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

public class TC_5 {
// TC #5: Selecting date on dropdown and verifying
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Select “December 1st, 1923” and verify it is selected.
//Select year using   : visible text
//Select month using: value attribute Select day using: index number

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown ");

    }

    @Test
    public void dateDropdown(){
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");




        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
//
//        List <Select> date = new ArrayList<>();
//        date.add(year);
//        date.add(month);
//        date.add(day);

        String expectedYear = "1923";
        String actualYear =year.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear,expectedYear);


        String expectedMonth = "December";
        String actualMonth = month.getFirstSelectedOption().getText();

        Assert.assertEquals(actualMonth,expectedMonth," month did not pass");


        String expectedDay= "1";
        String actualDay= day.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay,expectedDay,"day did not pass");





    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
