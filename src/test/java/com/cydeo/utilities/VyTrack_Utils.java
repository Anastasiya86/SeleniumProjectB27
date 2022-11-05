package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_Utils {
    public static void loginVyTrack(WebDriver driver, String username,String password){
        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameInputBox.sendKeys(username);

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordInputBox.sendKeys(password);

        WebElement logInButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        logInButton.click();
    }




}
