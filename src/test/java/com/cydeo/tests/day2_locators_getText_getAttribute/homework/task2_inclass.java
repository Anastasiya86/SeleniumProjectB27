package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task2_inclass {
    /*
    TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com");
        WebElement aBTesting = driver.findElement(By.linkText("A/B Testing"));
        aBTesting.click();
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("A/B Title test passed!");
        }else{
            System.out.println("A/B Title test failed!");
        }
        driver.navigate().back();
        String expectedTitle1 = "Practice";
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Practice Title test passed!");
        }else{
            System.out.println("Practice Title test failed!");
        }
        driver.quit();
    }
}
