package com.cydeo.tests.day7_windows_webtables.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NumberOfLinks {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }

    @Test (priority=1)
    public void checkingNumberOfLinks(){
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        int expectedSize = 355;
        int actualSize= allLinks.size();
        Assert.assertEquals(actualSize,expectedSize);

    }
     @Test (priority=2)
     public void printingTextOfLinks(){
         List<WebElement> allLinks = driver.findElements(By.tagName("a"));
         for (WebElement eachLink : allLinks) {
             System.out.println(eachLink.getText().trim()+ " * ");

         }
     }
    @Test (priority=3)
    public void countingEmptyTextLinks() {
//3. Count the number of links that does not have text and verify
//Expected: 109
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        int count=0;
        for(WebElement each : allLinks){
            if(each.getText().isEmpty()){
                count++;
        }
        }
        Assert.assertEquals(count,259);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
