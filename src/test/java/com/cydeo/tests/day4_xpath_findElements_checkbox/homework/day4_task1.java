package com.cydeo.tests.day4_xpath_findElements_checkbox.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class day4_task1 {
    public static void main(String[] args) {
//        TC #1: XPATH and cssSelector Practices
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/forgot_password
//        3. Locate all the WebElements on the page using XPATH and/or CSS
//        locator only (total of 6)
//        a. “Home” link
//        b. “Forgot password” header
//        c. “E-mail” text
//        d. E-mail input box
//        e. “Retrieve password” button
//        f. “Powered by Cydeo text
//        4. Verify all web elements are displayed.

        WebDriver  driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());

        WebElement homeLinkCss = driver.findElement(By.cssSelector("a[class='nav-link']"));


        WebElement cydeoLink = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println("Cydeo link is displayed " + cydeoLink.isDisplayed());
        WebElement cydeoLinkCss = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

    }


}
