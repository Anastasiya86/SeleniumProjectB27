package com.cydeo.tests.day13_pom_explicitwait.homework;

import com.cydeo.pages.Task1Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task1_2_3 {
    /*
    TC #1: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
     */
    Task1Page task1Page;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url"));
        task1Page = new Task1Page();
    }


    @Test
    public void required_field_error_message_test1(){
        task1Page.signInButton.click();
        Assert.assertTrue(task1Page.errorMessage.isDisplayed());
    }

    @Test
    public void invalid_email_format_error_message_test1(){
        BrowserUtils.sleep(5);
        task1Page.emailInput.sendKeys("annnlk");

        task1Page.signInButton.click();
        Assert.assertTrue(task1Page.emailErrormessage.isDisplayed());
    }

    @Test
    public void library_negative_login(){

        task1Page.emailInput.sendKeys("incorrect");

        task1Page.passwordInput.sendKeys("blahh");

        task1Page.signInButton.click();

        Assert.assertTrue(task1Page.finalErrorMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
