package com.cydeo.tests.day1_selenium_intro.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        if(currentUrl.contains("cydeo")){
            System.out.println("URL verification passed");
        }else{
            System.out.println("URL verification failed");
        }


        String title = driver.getTitle();
        System.out.println("title = " + title);

        if(title.equals("Practice")){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

        driver.quit();
    }
}
