package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hw_TC1 {
    public static void main(String[] args) {
        /*
        TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.etsy.com");

        WebElement buttonCookies = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        buttonCookies.click();
        WebElement searchBox= driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!");
        }else{
            System.out.println("Title verification failed!");
        }
        driver.quit();

    }
}
