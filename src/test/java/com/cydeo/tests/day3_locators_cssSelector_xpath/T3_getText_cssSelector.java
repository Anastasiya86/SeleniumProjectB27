package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getText_cssSelector {
    public static void main(String[] args) {

//    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
//  1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//  2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");
    //  3- Verify “Log in” button text is as expected:
    //    Expected: Log In

    //locate with using cssSelector by type attribute:
     //   WebElement logInBtn = driver.findElement(By.cssSelector("input[type='submit']"));

        //locate with using cssSelector by value attribute
        //WebElement logInBtn2 = driver.findElement(By.cssSelector("input[value='Log In']"));

        // Locate with using cssSelector by class attribute: with Syntax #2:
        //WebElement logInBtn3 = driver.findElement(By.cssSelector("input.login-btn"));

        // Locate with using cssSelector by onclick attribute
      //  WebElement logInBtn4 = driver.findElement(By.cssSelector("input[onclick=\"BX.addClass(this, 'wait');\"]"));


        // Locate with using cssSelector by class attribute:
        WebElement logInBtn = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String expectedLogInBtn = "Log In";
        String actualLogInBtn = logInBtn.getAttribute("value");

        if(actualLogInBtn.equals(expectedLogInBtn)){
            System.out.println("Login text verification passed!");
        }else{
            System.out.println("Login text verification failed!");
        }
        driver.quit();

    }
}