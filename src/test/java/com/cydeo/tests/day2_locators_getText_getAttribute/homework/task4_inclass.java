package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task4_inclass {
    public static void main(String[] args) {
        /*
        TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://library2.cydeo.com/login.html");

        WebElement usernameField = driver.findElement(By.className("form-control"));
        usernameField.sendKeys("incorrect@email.com");

        WebElement passwordField = driver.findElement(By.id("inputPassword"));
        passwordField.sendKeys("incorrect password" + Keys.ENTER);

        WebElement alert1 = driver.findElement(By.className("mb-4"));
        System.out.println("alert1.isDisplayed() = " + alert1.isDisplayed());
        driver.quit();
    }
}
