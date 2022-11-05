package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_FullScreenMode {
    public static void main(String[] args) {

        //set up chrome and create WebDriver instance
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //navigate to google and print out the title
        driver.get("https://cydeo.com");

       driver.manage().window().maximize();
      //  driver.manage().window().fullscreen();

    }
}
