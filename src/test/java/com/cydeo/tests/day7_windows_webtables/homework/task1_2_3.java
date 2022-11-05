package com.cydeo.tests.day7_windows_webtables.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task1_2_3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com/");
    }
    @Test
    public void checkNumberOfLinks(){
//3. Count the number of the links on the page and verify
//Expected: 332
        List<WebElement> allLinksList = driver.findElements(By.tagName("a"));
        System.out.println(allLinksList.size());
        int allLinksSize = allLinksList.size();
        int expectedSize = 355;
        Assert.assertEquals(allLinksSize,expectedSize);

        for (WebElement eachLink : allLinksList) {
            System.out.print(eachLink.getText().trim()+ ", ");
        }
        System.out.println();
        int count=0;
        for (WebElement eachLink : allLinksList) {
            if(eachLink.getText().isBlank()){
                count++;
            }

        }
        System.out.println(count);
        Assert.assertEquals(count,259);
    }


    @BeforeMethod
    public void tearDown(){
      //  driver.quit();
    }
}
