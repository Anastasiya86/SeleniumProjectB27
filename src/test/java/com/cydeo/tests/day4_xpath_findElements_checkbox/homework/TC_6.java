package com.cydeo.tests.day4_xpath_findElements_checkbox.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC_6 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);

        /*
        TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */
    driver.get("http://practice.cydeo.com/multiple_buttons");
        WebElement button1 = driver.findElement(By.xpath("//button[.='Button 1']"));
        button1.click();

    WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedMessage = "Clicked on button one!";
        String actualMessage = message.getText();



       if(actualMessage.equals(expectedMessage)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

    }
}
