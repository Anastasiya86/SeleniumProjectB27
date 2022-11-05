package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hm_TC3 {
    public static void main(String[] args)  {
        /*
        TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        WebElement button = driver.findElement(By.xpath("//button[@id='W0wltc']"));
        button.click();

        WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        String expectedTitle = "Gmail";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Gmail Title passed!");
        }else{
            System.out.println("Gmail Title failed!");
        }

        driver.navigate().back();

        String expectedTitle1 = "Google";
        String actualTitle1= driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Google Title passed!");
        }else{
            System.out.println("Google Title failed!");
        }



        driver.quit();



    }
}
