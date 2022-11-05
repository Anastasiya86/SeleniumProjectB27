package com.cydeo.tests.day12_actions_javascriptexecutor.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class task7 {
    /*
    TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
     */
    @Test
    public void JSScroll(){
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeo = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true)",cydeo);
        BrowserUtils.sleep(2);
       // js.executeScript("arguments[0].scrollIntoView(true)",home);
        js.executeScript("arguments[1].scrollIntoView(true)",cydeo,home);
    }
}
