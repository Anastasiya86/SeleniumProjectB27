package com.cydeo.tests.VyTrackProject;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.VyTrack_Utils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US_6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyEditCarInfo()   {
        driver.get("https://qa2.vytrack.com/user/login");

        VyTrack_Utils.loginVyTrack(driver,"User172","UserUser123");

        BrowserUtils.sleep(3);

        WebElement fleetModule = driver.findElement(By.xpath("//a[@class='unclickable']//span[@class='title title-level-1']"));
        BrowserUtils.sleep(3);
        Actions action = new Actions(driver);
        action.moveToElement(fleetModule).perform();
        BrowserUtils.sleep(3);
        WebElement vehicleCost = driver.findElement(By.xpath("//a[.='Vehicles']"));
        vehicleCost.click();
        BrowserUtils.sleep(3);
        WebElement threeDots = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tr[1]//td[20]"));
        //   Actions action1 = new Actions(driver);
        ////table[@class='grid table-hover table table-bordered table-condensed']/tbody//tr[1]//td[20]
        //table[@class='grid table-hover table table-bordered table-condensed']/tbody//tr[1]//div/a
        action.moveToElement(threeDots).perform();
        BrowserUtils.sleep(3);

        System.out.println(driver.getTitle() + " :" + driver.getCurrentUrl());

    }
}