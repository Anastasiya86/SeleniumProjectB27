package com.cydeo.tests.day11_upload_actions_javascriptexecutor.homework;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class task1 {
    /*
    TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
     */
    @Test
    public void registrationForm(){
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().firstName()+ faker.name().lastName());
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.name().firstName().toLowerCase() + "." + faker.name().lastName().toLowerCase()+"@gmail.com");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.bothify("??##????##"));
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("571-###-####"));

        List<WebElement> gender = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
        gender.get(faker.number().numberBetween(0,2)).click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("10/03/1980");

        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));

        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        Select jobDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobDropdown.selectByIndex(faker.number().numberBetween(1,8));

        WebElement signUp = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUp.click();

        WebElement message = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        System.out.println(message.isDisplayed());
        System.out.println(message.getText());
    }
}
