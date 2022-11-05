package com.cydeo.tests.day11_upload_actions_javascriptexecutor.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task2 {
    /*
    Guru99 Upload Test

1. Go to “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of servide check box
4. Click Submit File button
5. Verify expected message appeared. Expected:
“1 file
has been successfully uploaded.”
     */

    @Test
    public void uploadTest(){
        Driver.getDriver().get("http://demo.guru99.com/test/upload");

        Driver.getDriver().switchTo().frame("gdpr-consent-notice");

        WebElement rejectAll = Driver.getDriver().findElement(By.xpath("(//span[.='Reject All'])[2]"));
        rejectAll.click();
        BrowserUtils.sleep(1);
        WebElement rejectButton = Driver.getDriver().findElement(By.xpath("//span[.='Reject']"));
        rejectButton.click();
        Driver.getDriver().switchTo().defaultContent();


        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("C:\\Users\\anast\\Downloads\\some-file (1).txt");

        WebElement termsCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        termsCheckbox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        BrowserUtils.sleep(1);
        String expectedMessage = "1 file\n" +
                "has been successfully uploaded.";
        WebElement message = Driver.getDriver().findElement(By.id("res"));
        BrowserUtils.sleep(1);
        String actualResult = message.getText();
        Assert.assertEquals(actualResult,expectedMessage);
    }
}
