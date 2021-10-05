package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDryRun {

    public static void main(String[] args) {

        // 1. Setup Chrome Driver so selenium can use it to automate chrome
        WebDriverManager.chromedriver().setup();

        // 2. Create Chrome Driver Object to open browser
        WebDriver driver = new ChromeDriver();

        // 3. Navigate to https://google.com
        driver.get("https://google.com");
    }
}