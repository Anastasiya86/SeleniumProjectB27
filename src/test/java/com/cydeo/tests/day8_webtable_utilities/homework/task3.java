package com.cydeo.tests.day8_webtable_utilities.homework;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class task3 {

public static void verifyTitle(WebDriver driver,String expectedTitle ){

    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);
}
}
