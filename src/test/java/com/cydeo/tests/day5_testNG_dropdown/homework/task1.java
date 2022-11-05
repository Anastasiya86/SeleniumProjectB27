package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task1 {
    /*
    TC #1: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyBtn.click();
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());


        List<WebElement> allSportBtns = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement eachSport : allSportBtns) {

            eachSport.click();
            if(eachSport.isSelected()){
                System.out.println(eachSport.getAttribute("id") + " radio button is selected");
            }else{
                System.out.println(eachSport.getAttribute("id") + " radio button is not selected");
            }

        }

        List<WebElement> favoriteColor = driver.findElements(By.xpath("//input[@name='color']"));
        for (WebElement eachColor : favoriteColor) {
            eachColor.click();
            if(eachColor.isSelected()){
                System.out.println(eachColor.getAttribute("id") + " radio button is selected");

            }else{
                System.out.println(eachColor.getAttribute("id") + " radio button is not selected");
            }

        }



        driver.quit();

    }
}
