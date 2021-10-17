package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Set;

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
    }
}