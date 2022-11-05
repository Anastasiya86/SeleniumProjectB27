package com.cydeo.tests.day11_upload_actions_javascriptexecutor.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task3 {
    /*
    #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
 4. Hover over to second image
 5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
 6. Hover over to third image
 7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed
     */

    @Test
    public void hoverTest1(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement image2= Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        WebElement viewProfile1 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        WebElement viewProfile2 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        WebElement viewProfile3 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1.isDisplayed());
        Assert.assertTrue(viewProfile1.isDisplayed());
        BrowserUtils.sleep(2);

        actions.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed());
        Assert.assertTrue(viewProfile2.isDisplayed());
        BrowserUtils.sleep(2);

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());



    }
}
