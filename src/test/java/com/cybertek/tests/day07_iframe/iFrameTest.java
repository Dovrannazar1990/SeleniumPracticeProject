package com.cybertek.tests.day07_iframe;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {

    @Test
    public void testSimpleIFrame() {

        driver.get("http://practice.cybertekschool.com/iframe");

        // Locate the <p> element inside iframe
        // First we need to switch to the iFrame: by index
        driver.switchTo().frame(0);
        WebElement pTagInsideFrame = driver.findElement(By.tagName("p"));
        System.out.println("pTagInsideFrame.getText() = " + pTagInsideFrame.getText());

    }
}