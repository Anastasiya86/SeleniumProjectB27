package com.cydeo.tests.day8_webtable_utilities.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class smartbear {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test (priority = 1)
    public void smartBearVerification (){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameInput.sendKeys("Tester");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();


        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links on webpage: " + allLinks.size());
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());

        }

    }
    @Test(priority = 2)
    public  void orderPlacing(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameInput.sendKeys("Tester");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        Select productDropdown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productDropdown.selectByIndex(1);
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        BrowserUtils.sleep(3);
        quantityInput.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@onclick='productsChanged(); return false;']"));
        calculateButton.click();

        Faker faker = new Faker();
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.sendKeys(faker.name().fullName());
        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys(faker.address().streetAddress());
       WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
       city.sendKeys(faker.address().city());
       BrowserUtils.sleep(3);
      WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
      zip.sendKeys(faker.numerify("#####"));

     WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
     visaButton.click();
     WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        BrowserUtils.sleep(3);
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));
    WebElement date = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));

       date.sendKeys("11/25");
       WebElement processBtn = driver.findElement(By.xpath("//a[@class='btn_light']"));
       processBtn.click();

        WebElement message = driver.findElement(By.xpath("//strong"));
        String actual = message.getText();
        String expected = "New order has been successfully added.";
        Assert.assertEquals(actual,expected);
    }


}
