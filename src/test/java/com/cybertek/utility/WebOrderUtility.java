package com.cybertek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public static void login(WebDriver driverParam, String username, String password) {

        // Below line will not work because it will open new driver each time
        // WebDriver driver = WebDriverFactory.getDriver("chrome");

        // Enter username
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // Enter password
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        // Click login
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    public static void logout(WebDriver driveParam) {

        // Logout link has id of ctl00_logout
        driveParam.findElement(By.id("ctl00_logout")).click();
    }

    public static boolean isAtOrderPage(WebDriver driveParam) {
        // You can also check the url
        // You can check the title if it's different
        // whatever that makes sense
        // Here we decided to check one element
        boolean result = false;
        /*
         * Locator for the header element of all order page
         * //h2[normalize-space(.)='List of All Orders']
         * TODO: Try to replace this with WebDriverWait
         * Since it will wait 10 second set by implicit wait if not found
         */
        try {
            WebElement header = driveParam.findElement(By.xpath("//h2[normalize-space(.)='List of All Orders']"));
            System.out.println("Element was identified");
            System.out.println("header.isDisplayed() = " + header.isDisplayed());
            result = true;
        } catch (NoSuchElementException e) {
            System.out.println("No such element! You are not at the right page");
        }
        return result;
//        System.out.println("header.isDisplayed() = " + header.isDisplayed());
    }
}