package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class task2 {
    /*
    TC #2: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
     */
    public static void main(String[] args) {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addBtn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addBtn.click();
        WebElement deleteBtn = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        deleteBtn.click();
        try{
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        }catch(StaleElementReferenceException e){
            System.out.println("Stale element exception: element is not attached to the page document");
        }
        driver.quit();
    }
}
