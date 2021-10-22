package com.cybertek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// THIS IS NOT TEST CLASS SO WE CANNOT EXTEND TESTBASE
// IT SIMPLY DOES NOT MAKE SENSE
public class WebOrderUtility {

    public static void login(WebDriver driverParam) {

        // Below line will not work because it will open new driver each time
        // WebDriver driver = WebDriverFactory.getDriver("chrome");

        // Enter username
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // Enter password
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        // Click login
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
}