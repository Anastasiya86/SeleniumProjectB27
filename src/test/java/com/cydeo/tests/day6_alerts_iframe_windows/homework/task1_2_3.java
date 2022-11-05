package com.cydeo.tests.day6_alerts_iframe_windows.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class task1_2_3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Set up browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test (priority = 1)
    public void alert1(){
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertBtn.click();
      Alert alert =  driver.switchTo().alert();
      alert.accept();

      WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
      String actualResult = result.getText();
      String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test (priority = 2)
    public void alert2(){
        WebElement confirmationBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmationBtn.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        WebElement result1 = driver.findElement(By.xpath("//p[@id='result']"));
        String actualRes = result1.getText();
        String expectedRes = "You clicked: Ok";
        Assert.assertEquals(actualRes,expectedRes);
    }
    @Test (priority = 3)
    public void alert3(){
        WebElement alert3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alert3.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement finalRes= driver.findElement(By.xpath("//p[@id='result']"));
        String actualFinalRes= finalRes.getText();
        String expectedFinalRes = "You entered: hello";
        Assert.assertEquals(actualFinalRes,expectedFinalRes);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}