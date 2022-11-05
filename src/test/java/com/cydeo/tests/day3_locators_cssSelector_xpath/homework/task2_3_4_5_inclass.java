package com.cydeo.tests.day3_locators_cssSelector_xpath.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task2_3_4_5_inclass {
    /*
    TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");
        WebElement rememberText = driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']"));
        String expectedText ="Remember me on this computer";
        String actualText = rememberText.getText();
        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


        WebElement passwordText = driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']"));
        String expectedPasswordText ="FORGOT YOUR PASSWORD?";
        String actualPasswordText = passwordText.getText();
        System.out.println("passwordText.getText() = " + passwordText.getText());
        if(actualPasswordText.equals(expectedPasswordText)){
            System.out.println("Passed");

        }else{
            System.out.println("Failed");
        }

        String passTextAttribute = passwordText.getAttribute("href");
        System.out.println("passwordText.getAttribute(\"href\") = " + passwordText.getAttribute("href"));

        if(passTextAttribute.contains("forgot_password=yes")){
            System.out.println("Attribute test passed");
        }else{
            System.out.println("Attribute test failed");
        }

        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        String actualLogInText = logInButton.getAttribute("value");
        String expectedLogInText = "Log In";
        if(actualLogInText.equals(expectedLogInText)){
            System.out.println("LogIN button passed!");
        }else{
            System.out.println("LogIN button failed!");
        }

        passwordText.click();
        WebElement resetPasswordBtn = driver.findElement(By.xpath("//button[@class='login-btn']"));
        String expectedResetBtn ="Reset password";
        String actualResetBtn = resetPasswordBtn.getText();
        if(actualResetBtn.equals(expectedResetBtn)){
            System.out.println("Reset Button passed");
        }else{
            System.out.println("Reset Button failed");
        }

        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("incorrect");

        WebElement resetPass = driver.findElement(By.xpath("//button[@value='Reset password']"));
        resetPass.click();

        WebElement errorText = driver.findElement(By.xpath("//div[@class='errortext']"));
        String actualErrorText = errorText.getText();
        String expectedErrorText = "Login or E-mail not found";
        if(actualErrorText.equals(expectedErrorText)){
            System.out.println("error message text passed");
        }
        else{
            System.out.println("error message text failed");
        }
driver.quit();
    }
}
