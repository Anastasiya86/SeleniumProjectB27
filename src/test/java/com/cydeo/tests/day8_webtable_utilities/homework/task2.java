package com.cydeo.tests.day8_webtable_utilities.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class task2 {
    /*
    TC #2: Web table practice Task1 cont.
1. Create a new class called WebTableUtils.
2. Create two methods to verify order
Method #1 info:
• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String costumerName
This method should accept a costumerName and return the costumer order date
as a String.

Method #2 info:
• Name: orderVerify ()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String costumerName
• Arg3: String expectedOrderDate
This method should accept above mentioned arguments and internally assert
expectedOrderDate matching actualOrderDate.
     */


        public static String returnOrderDate(WebDriver driver, String costumerName){
            String locator = "//table[@id='ctl00_MainContent_orderGrid']//td[.='" + costumerName+"']/following-sibling::td[3]";
                WebElement returnOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='" + costumerName+"']/following-sibling::td[3]"));
                return returnOrderDate.getText();
        }

        public void orderVerify (WebDriver driver, String costumerName,String expectedOrderDate){
        WebElement customerOrderDate =
                driver.findElement(By.xpath("//td[.='" + costumerName + "']/following-sibling::td[3]"));

                String actualOrderDate = customerOrderDate.getText();

                Assert.assertEquals(actualOrderDate,expectedOrderDate);
}



}
