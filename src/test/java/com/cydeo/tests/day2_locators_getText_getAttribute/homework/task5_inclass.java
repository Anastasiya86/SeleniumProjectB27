package com.cydeo.tests.day2_locators_getText_getAttribute.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task5_inclass {
    public static void main(String[] args) {
        /*
        TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/registration_form");

        WebElement header = driver.findElement(By.className("page-header"));
        String expectedHeader = "Registration form";
        String actualHeader = header.getText();
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        WebElement firstNameInputBox = driver.findElement(By.name("firstname"));
        String actualPlaceholder = firstNameInputBox.getAttribute("placeholder");
        String expectedPlacehlder = "first name";
        if(actualPlaceholder.equals(expectedPlacehlder)){
            System.out.println("Placeholder verified!");
        }else{
            System.out.println("Placeholder failed!");
        }


    }
}
