package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorTest extends TestBase {

    // window.scrollBy(0,1000)
    @Test
    public void testScrollWholeWindow() {
        // Navigate to infinite scroll page
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        // Scroll by 1000 px down, no need for left and right scroll
        BrowserUtil.waitFor(2);
        // Get JavascriptExecutor reference from driver variable
        // So we can run this js code window.scrollBy(0,1000)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // It uses execute method to run javascript, it can accept parameter
        jse.executeScript("window.scrollBy(0,1000)");

        // Scrolling once is not obvious, let's loop and scroll 10 times and wait 1 sec
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,1000)");
            BrowserUtil.waitFor(1);
        }

        BrowserUtil.waitFor(4);
    }

    @Test
    public void testScrollElementIntoView() {

        // Navigate to http://practice.cybertekschool.com/large
        driver.get("http://practice.cybertekschool.com/large");

        // Get jse
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /*
         * Locate cybertekSchoolLnk and homeLnk
         * Run this javascript to scroll the element into the view
         * theElementIdentified.scrollIntoView(true)
         * In order to pass our element into above method
         * we need to use arguments[specify index here]
         * whatever we pass to executeScript method after Javascript code will be argument with index
         */

        // Try out passing argument in window.scrollBy(0,1000)
        // I want to pass this 1000 externally when I call the method
        int myScrollNumber = 1000;
        jse.executeScript("window.scrollBy(0, arguments[0])", myScrollNumber);

        // Now call argument[0].scrollIntoView(true)
        WebElement cybertekSchoolLnk = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLnk);

        BrowserUtil.waitFor(4);
    }
}