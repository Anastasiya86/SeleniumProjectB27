package com.cydeo.tests.day11_upload_actions_javascriptexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {
    /*
    TC #2: Guru99 Upload Test

1. Go to “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of servide check box
4. Click Submit File button
5. Verify expected message appeared. Expected:
“1 file
has been successfully uploaded.”
     */

    @Test
    public void guru99_upload_test() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        //C:\Users\anast\Downloads\some-file.txt
        Thread.sleep(3000);
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='gdpr-consent-notice']")));


        WebElement rejectAll = Driver.getDriver().findElement(By.xpath("(//span[.='Reject All'])[2]"));
        rejectAll.click();
        WebElement reject = Driver.getDriver().findElement(By.xpath("//button[@class='mat-focus-indicator okButton mat-raised-button mat-button-base']"));
        reject.click();

        Driver.getDriver().switchTo().defaultContent();

        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("C:\\Users\\anast\\Downloads\\some-file.txt");

        WebElement acceptTerms = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        acceptTerms.click();
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message = Driver.getDriver().findElement(By.id("res"));
        Thread.sleep(2000);
        Assert.assertEquals(message.getText(),"1 file\n" +
                "has been successfully uploaded.");
    }
}
