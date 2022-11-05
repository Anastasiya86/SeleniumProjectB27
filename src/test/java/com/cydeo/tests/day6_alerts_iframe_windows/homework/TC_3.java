package com.cydeo.tests.day6_alerts_iframe_windows.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_3 {
//TC #3: Information alert practice
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Prompt” button
//4. Send “hello” text to alert
//5. Click to OK button from the alert


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Set up browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void testMessage(){
        WebElement clickBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickBtn.click();

       Alert alert = driver.switchTo().alert();
       alert.sendKeys("hello");
       alert.accept();
        //6. Verify “You entered:  hello” text is displayed.


        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        String actualResult= result.getText();
        String expectedResult = "You entered: hello";

        Assert.assertTrue(actualResult.equals(expectedResult));


    }





}