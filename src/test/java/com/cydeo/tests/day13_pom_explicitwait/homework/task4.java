package com.cydeo.tests.day13_pom_explicitwait.homework;

import com.cydeo.pages.Task4Page;
import com.cydeo.pages.Task4_1Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task4 {
/*
TC#4 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.

 */



    @Test
    public void dynamicallyLoadedPage(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        Task4Page task4Page = new Task4Page();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(task4Page.doneMsg.isDisplayed());
        BrowserUtils.sleep(5);
        Assert.assertTrue(task4Page.spongeBob.isDisplayed());
    }

    @Test
    public void dynamically_Loaded_Page_Elements_11(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        Task4_1Page task4_1Page = new Task4_1Page();

        task4_1Page.startBtn.click();
        BrowserUtils.waitForInvisibilityOf(task4_1Page.loadingBar1);

        Assert.assertTrue(task4_1Page.usernameInputBox.isDisplayed());

        task4_1Page.usernameInputBox.sendKeys("tomsmith");
        task4_1Page.passwordInputBox.sendKeys("incorrectpassword");
        task4_1Page.submitBtn.click();
        Assert.assertTrue(task4_1Page.message.isDisplayed());


    }


//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }


}
