package com.cydeo.tests.day6_alerts_iframe_windows.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_5 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Set up browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void windowsTask() {

        String mainWindow = driver.getWindowHandle();


        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Before opening new window " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereBtn.click();

        actualTitle = driver.getTitle();
        System.out.println("After opening new window " + actualTitle);

        //6. Switch to new Window.
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
             if(driver.getTitle().equals("New Window")){
                 System.out.println(driver.getTitle());
                 break;
             }


      // System.out.println("eachWindow = " + eachWindow);
      // System.out.println("driver.getTitle() = " + driver.getTitle());
        }

    }

}
