package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hw_TC2 {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement headerText = driver.findElement(By.className("page-header"));
        System.out.println(headerText.getText());
        String expectedHeader = "Log in to ZeroBank";
        String actualHeader= headerText.getText();
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        driver.quit();
    }
}
