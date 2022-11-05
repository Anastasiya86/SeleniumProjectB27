package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task4_1Page {
    public Task4_1Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startBtn;

    @FindBy (xpath = "//div[@id='loading']")
    public WebElement loadingBar1;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@id='pwd']")
    public WebElement passwordInputBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy (xpath = "//div[@id='flash']")
    public WebElement message;


}
