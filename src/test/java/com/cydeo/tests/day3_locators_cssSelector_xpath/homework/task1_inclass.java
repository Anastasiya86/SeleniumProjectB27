package com.cydeo.tests.day3_locators_cssSelector_xpath.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task1_inclass {
    /*
    TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");

        WebElement loginField = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginField.sendKeys("incorrect");
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordField.sendKeys("incorrect");
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        WebElement messageText = driver.findElement(By.xpath("//div[@class='errortext']"));
        String expectedText = "Incorrect login or password";
        String actualText = messageText.getText();
        if(actualText.equals(expectedText)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }


driver.quit();

    }
}
