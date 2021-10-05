package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {

        // Set up chrome driver
        WebDriverManager.chromedriver().setup();

        // create ChromeDriver Object
        WebDriver driver = new ChromeDriver();

        // Navigate to https://www.yahoo.com/
        driver.get("https://www.yahoo.com/");

        /*
            - get("url")
            - navigate().to("url")
            - navigate().back()
            - navigate().forward()
            - navigate().refresh()
        */

        // navigate().to("url")
        driver.navigate().to("https://www.google.com/");
    }
}
