package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ExplicitWaitTest extends TestBase {

    @Test
    public void testWaitForTitle() {

        // 1. Navigate to http://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        // 2. Click on example 7
        driver.findElement(By.partialLinkText("Example 7")).click();

    }


}