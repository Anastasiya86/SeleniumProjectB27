package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitle {
    /*
    TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement  woodenSpoon = driver.findElement(By.linkText("wooden spoon"));
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Wooden Spoon title verification passed");
        }
        else{
            System.out.println("Wooden Spoon title verification failed");
        }
        Thread.sleep(5000);
        driver.close();

    }
}
