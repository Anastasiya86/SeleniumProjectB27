package com.cydeo.tests.day1_selenium_intro.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_1 {
    /*
    TC #1: Cydeo Title Verification
1. Open Chrome browser
2. Go to https://www.cydeo.com
3. Verify title:
Expected: Cydeo
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cydeo.com");
        System.out.println("Title: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle ="Cydeo";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        driver.quit();
    }


}
