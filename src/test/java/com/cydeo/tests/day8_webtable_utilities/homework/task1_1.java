package com.cydeo.tests.day8_webtable_utilities.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task1_1 {
    /*
    TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
     */
    @Test
    public void webTablePractice(){
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");

        WebElement bobMartinName = Driver.getDriver().findElement(By.xpath("((//table/tbody/tr)[8]/td)[2]"));
        Assert.assertEquals(bobMartinName.getText(),"Bob Martin");
}
}
