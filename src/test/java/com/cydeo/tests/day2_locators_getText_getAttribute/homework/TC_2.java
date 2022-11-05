package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_2 {
    public static void main(String[] args) {
       /*
       TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement name = driver.findElement(By.tagName("h3"));

        String expectedHeaderText = "Log in to ZeroBank";

        String actualHeaderText = name.getText();

       if(actualHeaderText.equals(expectedHeaderText)){
           System.out.println("pass");
       }else{
           System.out.println("fail");
       }


    }
}
