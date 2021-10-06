package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation_LocalHTML_File {

    public static void main(String[] args) {


        // Set up chrome driver, open chrome browser
        WebDriverManager.chromedriver().setup();

        // Navigate to that html file using that path you copied from the browser
        WebDriver driver = new ChromeDriver();

        // file:///Users/dovran/Desktop/HTML_Class/Day2.html
        driver.get("file:///Users/dovran/Desktop/HTML_Class/Day2.html");

        // Close the browser
        driver.quit();
    }
}