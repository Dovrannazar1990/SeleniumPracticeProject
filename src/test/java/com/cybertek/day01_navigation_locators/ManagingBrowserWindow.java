package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingBrowserWindow {

    public static void main(String[] args) {

        // Set up chrome driver
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver Object
        WebDriver driver = new ChromeDriver();

        // Navigate to https://google.com
        driver.get("https://google.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Make the browser window full screen
        driver.manage().window().fullscreen();

        // Quit the browser
        driver.quit();
    }
}