package com.cydeo.tests.day12_actions_javascriptexecutor.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task12 {
    /*
    TC #: Drag and drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
     */
    @Test
    public void dragAndDrop(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement cookiesAccept = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesAccept.click();

        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

//        actions.clickAndHold(smallCircle)
//                .pause(2000)
//                .moveToElement(bigCircle)
//                .pause(2000)
//                .release(bigCircle)
//                .perform();
        actions.dragAndDrop(smallCircle,bigCircle).perform();

        String actualResult = bigCircle.getText();
        String expectedResult = "You did great!";
        Assert.assertEquals(actualResult,expectedResult);


    }
}
