package com.cybertek.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class is meant to be super class to provide
 * driver set up and closing browser for it's subclasses
 *
 * Now you can try to replace driver with
 * Driver.getDriver() so it can be same driver anywhere where ever you use
 */
public abstract class TestBase {

    // We want only subclasses of TestBase have access to this
    protected WebDriver driver;
    // Setting up all driver stuff here directly in @BeforeEach method
    @BeforeEach
    public void setUpWebDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver = Driver.getDriver(); // WebDriverFactory.getDriver("chrome");
        // This is how we can set maximum timeout for finding element
        // in this example it will wait for 10 seconds
        // if element is found in 1 second, it will just move on without finishing 10 seconds
        // Thread.sleep(10000) will always wait for 10 seconds no matter what
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {

        // driver.quit();
        // Quit the browser and make it null, so we can get new one when ask for it again
        Driver.closeBrowser();
    }
}