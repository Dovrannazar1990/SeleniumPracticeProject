package com.cybertek.utility;

import org.openqa.selenium.By;

public class WebOrderUtil {

    /*
     * Simply navigate to WebOrderApp
     */

    public static void openWebOrderApp() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
    }

    /*
     * A method for logging into Web Order practice site from login page
     */

    public static void login() {

        // Enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // Enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        // Click login
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    /**
     * A method for logging into Web Order practice site from login page
     *
     * @param username username for webOrder app
     * @param password password for webOrder app
     */

    public static void login(String username, String password) {

        // Enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // Enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        // Click login
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    /**
     * Check for login error message is visible or not, by calling the BrowserUtil method we created
     * @return true if error message displayed, false if not
     */

    public static boolean loginErrorMsgVisible() {

        boolean elementFound =
                BrowserUtil.checkVisibilityOfElement(By.xpath("//span[. ='Invalid Login or Password.']"), 2);
        return elementFound;
    }
}