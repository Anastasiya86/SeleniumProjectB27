package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task1Page {
    public Task1Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="inputEmail")
    public WebElement emailInput;

    @FindBy(xpath="//input[@id='inputPassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy (xpath = "//div[.='This field is required.']/div")
    public WebElement errorMessage;

    @FindBy (xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement emailErrormessage;

    @FindBy (xpath="//div[.='Sorry, Wrong Email or Password']")
    public WebElement finalErrorMessage;


}
