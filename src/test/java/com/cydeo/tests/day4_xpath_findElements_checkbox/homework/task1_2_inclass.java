package com.cydeo.tests.day4_xpath_findElements_checkbox.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task1_2_inclass {
    /*
    TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password

     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/forgot_password");

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of hyperlinks: " + links.size());

        for (WebElement eachLink: links){
            System.out.println( "Name: " + eachLink.getText());
            System.out.println("URL: "+eachLink.getAttribute("href"));
        }
        driver.quit();
    }

}
