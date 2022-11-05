package com.cydeo.tests.day1_selenium_intro.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_1_homework {
    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to
https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
 Expected: Practice
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com");


        String expectedUrl= "cydeo";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl)){
            System.out.println("URL test passed");
            System.out.println("URL: " + driver.getCurrentUrl());
        }else{
            System.out.println("URL test failed");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title test passed");
            System.out.println("Title: " + driver.getTitle());
        }else{
            System.out.println("Title test failed");
        }
        driver.quit();
    }

}
