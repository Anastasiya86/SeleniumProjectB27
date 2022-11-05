package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task1_inclass {
    /*
    TC #1: Excelsoir Insurance App verifications
1. Open Chrome browser
2. Go to
https://www.qa1.excelsoirinsurance.com/login
3. Verify URL contains
 Expected: "excelsoirinsurance"
4. Verify title:
 Expected: "Login | Excelsoir Insurance"
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.qa1.excelsoirinsurance.com/login");
        String expectedURL= "excelsoirinsurance";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains(expectedURL)){
            System.out.println("URL test passed");
        }else{
            System.out.println("URL test failed");
        }
        String expectedTitle = "Login | Excelsoir Insurance";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title test passed");
        }else{
            System.out.println("Title test failed");
        }
        driver.quit();
    }
}
