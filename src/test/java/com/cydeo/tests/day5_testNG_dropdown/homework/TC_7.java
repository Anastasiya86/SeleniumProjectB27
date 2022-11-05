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

public class TC_7 {
//TC #7: Selecting value from multiple select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Select all the options from multiple select dropdown.
//4. Print out all selected values.
//5. Deselect all values.


  WebDriver driver;

  @BeforeMethod
 public void setUp(){
      driver= WebDriverFactory.getDriver("Chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
      driver.get("https://practice.cydeo.com/dropdown");
   }

   @Test
    public void multipleDropdown(){

       Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

     for(WebElement each: languages.getOptions()){
         each.click();
         System.out.println("languages: " + each.getText());
     }

     languages.deselectAll();
   }

   @AfterMethod
    public void tearDown(){
      driver.quit();
   }

}
