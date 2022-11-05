package com.cydeo.tests.day12_actions_javascriptexecutor.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class task1 {
    /*
    TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method
     */

    @Test
    public void scrollDown(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        WebElement cydeo = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(cydeo).perform();
        BrowserUtils.sleep(2);

        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();



    }
}
