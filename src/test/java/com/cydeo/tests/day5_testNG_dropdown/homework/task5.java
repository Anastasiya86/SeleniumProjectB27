package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class task5 {
    /*
    TC #5: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using : visible text
Select month using : value attribute Select
day using : index number
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropdown() {
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByValue("1923");
        String finalSelectedYear = year.getFirstSelectedOption().getText();
        Assert.assertEquals(finalSelectedYear, "1923");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByVisibleText("December");
        String finalSelectedMonth = month.getFirstSelectedOption().getText();
        Assert.assertEquals(finalSelectedMonth, "December");


        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        String finalSelectedDay = day.getFirstSelectedOption().getText();
        Assert.assertEquals(finalSelectedDay,"1");

        List<WebElement> allDays = new ArrayList<>(day.getOptions());

        for (WebElement eachday : allDays) {
            if (eachday.getText().equals("5")) {
                System.out.println("sixth");
                break;
            }

        }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }


    }
}



