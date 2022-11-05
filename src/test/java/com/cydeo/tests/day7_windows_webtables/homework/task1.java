package com.cydeo.tests.day7_windows_webtables.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class task1 {
    /*
    TC : Multiple Windows practice
1. Open a chrome browser
2. Go to : https://practice.cydeo.com/windows
 3. Assert: Title is “Windows”
4. Click to: “Click Here” link
5. Click to: “CYDEO” link
6. Switch to Cydeo page.
7. Assert: Title is “Cydeo”
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void multipleWindows() {
        driver.get("https://practice.cydeo.com/windows");
        Assert.assertEquals(driver.getTitle(), "Windows");

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        WebElement cydeo = driver.findElement(By.xpath("//a[.='CYDEO']"));
        clickHere.click();
        cydeo.click();

        Set<String> alllinks = driver.getWindowHandles();
        for (String eachLink : alllinks) {
            driver.switchTo().window(eachLink);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            if (driver.getTitle().equals("Cydeo")) {
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(),"Cydeo");
    }
}
