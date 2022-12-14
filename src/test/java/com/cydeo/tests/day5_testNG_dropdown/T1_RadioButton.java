package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_RadioButton {
    public static void main(String[] args) {
//        Radiobutton handling
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioBtn.click();


//        4. Verify “Hockey” radio button is selected after clicking.

      System.out.println("hockeyRadioBtn.isSelected() = " + hockeyRadioBtn.isSelected());


        if(hockeyRadioBtn.isSelected()){
            System.out.println("Hockey button is selected!");
        }else{
            System.out.println("Hockey button is not selected!");
        }
        //Test all sport radio buttons if they are clickable

        List<WebElement> sportRadioBtns = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement eachSport : sportRadioBtns) {
            eachSport.click();
            if(eachSport.isSelected()){
                System.out.println(eachSport.getAttribute("id")+ " Radio button is selected");
            }else{
                System.out.println(eachSport.getAttribute("id") + " Radio button is not selected");
            }
        }


       // driver.quit();
    }
}
