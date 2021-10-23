package com.cybertek.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * We wanted to have a class with that only return Singleton object
 * no matter how many times you asked for object
 * So we are creating this class with technic we learned from Singleton pattern
 */

public class Driver {

    private static WebDriver obj;

    private Driver() {
    }

    public static WebDriver getDriver() {

        if (obj == null) {
            WebDriverManager.chromedriver().setup();
            obj = new ChromeDriver();
            System.out.println("One and only created for the first time.");
            return obj;
        } else {
            System.out.println("You have it. Just use existing one.");
            return obj;
        }

    }

}