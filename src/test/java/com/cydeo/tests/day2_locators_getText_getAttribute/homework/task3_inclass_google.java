package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task3_inclass_google {
    /*
    TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        WebElement button = driver.findElement(By.xpath("//button[@id='W0wltc']"));
        button.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchField.sendKeys("apple"+ Keys.ENTER);
        String expectedTitle= "apple";
        String actualTitle = driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        if(actualTitle.startsWith("apple")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
driver.quit();




    }



}
