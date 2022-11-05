package com.cydeo.tests.day6_alerts_iframe_windows.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Set up browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }
    @Test
    public void iframeTest(){
//4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        String actualtext = text.getText();

        String expectedText = "Your content goes here.";
        Assert.assertEquals(actualtext,expectedText);
        Assert.assertTrue(actualtext.equals(expectedText));
        System.out.println("text.isDisplayed() = " + text.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeader = header.getText();
        Assert.assertEquals(header,expectedHeader);




    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
