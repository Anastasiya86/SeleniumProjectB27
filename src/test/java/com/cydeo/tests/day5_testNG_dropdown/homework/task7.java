package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class task7 {
    /*
    TC #7: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
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
    public void multipleDropdown(){
        Select multiple = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        for (WebElement eachLanguage : multiple.getOptions()) {
            eachLanguage.click();
            if(eachLanguage.isSelected()){
                System.out.println(eachLanguage.getAttribute("value") + " language selected");
            }else{
                System.out.println(eachLanguage.getAttribute("value") + " language not selected");
            }
        }
        multiple.deselectAll();


    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
