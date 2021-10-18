package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest extends TestBase {

    @Test
    public void testWindowOrTab() {

        // Selenium see window or tab with no difference
        // Every tab is new window for selenium
        driver.get("http://practice.cybertekschool.com/windows");

        // Save windowHandle of this tab into currentHandle variable
        String currentHandle = driver.getWindowHandle();
        System.out.println("currentHandle = " + currentHandle);

        // Try to use getWindowHandles() method and print it out
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        // Click on the link to generate new tab|window
        WebElement clickHereLnk = driver.findElement(By.linkText("Click Here"));
        clickHereLnk.click(); // This will open new tab, so now you have 2 tabs

        // Now print out current and all window handles
        // It should be the same as whatever we got previously
        System.out.println("After clicking driver.getWindowHandle() = " + driver.getWindowHandle());

        // Print all window handles
        // After you click, you have 2 tabs now in order to get all of them
        // You can call driver.getWindowHandles() and we can print it out
        System.out.println("After clicking driver.getWindowHandles() = " + driver.getWindowHandles());

        // Our objective is to iterate over each and every handle
        // And use switch method to switch to the window
        // Print out its title
        // This is reassigning the variable to new handles
        allHandles = driver.getWindowHandles(); // This will give us latest all handles

        // Iterate over Collection, you can use for each loop
        for (String eachHandle : allHandles) {
            System.out.println("eachHandle = " + eachHandle);
            // THIS IS HOW YOU SWITCH TO DIFFERENT WINDOW|TAB
            driver.switchTo().window(eachHandle);
            // Now we can print out the title, so we know what tab we are in right now
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        // At the end of execution we observed
        // Last switched window was window with the title "New Window"
        // Now we want to go back to original tab, so we can continue to work on it
        System.out.println("SWITCHING BACK TO ORIGINAL TAB");
        driver.switchTo().window(currentHandle);
        // Assert the title is now "Practice"
        System.out.println("current tab title = " + driver.getTitle());
        assertEquals("Practice", driver.getTitle());
    }
}