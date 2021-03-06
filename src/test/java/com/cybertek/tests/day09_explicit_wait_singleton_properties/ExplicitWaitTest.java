package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExplicitWaitTest extends TestBase {

    @Test
    public void testWaitForTitle() {

        // 1. Navigate to http://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        // 2. Click on Example 7
        driver.findElement(By.partialLinkText("Example 7")).click();

        // 3. The title will show loading... until certain time,
        // We want to wait until the title value become "Dynamic title"
        // This is how we create WebDriverWait object with driver and max time to wait
        WebDriverWait wait = new WebDriverWait(driver, 6);
        // Then we use until method that accept expected conditions
        // ExpectedConditions helper class has a lot of pre-written conditions
        // For common scenarios, so we don't have to build our own
        // In this case we are checking for title equal Dynamic title
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        // Try different condition as below
        // Wait until the spongebob image visible on screen
        // visibilityOfElementLocated accept locator as parameter
        // So this means wait max 6 seconds until the element located by tagName("img")
        // is visible on the screen
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));

        // We did static import as below so pure code can be shorter
        // import static org.openqa.selenium.support.ui.ExpectedConditions.*;
        // wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));

        // The warning area initially has text of this page is slow wait for 5 seconds...
        // After it loading the text of that area become Done!
        // This is one of the ExpectedConditions we can use for waiting
        System.out.println("The end");
    }

    @Test
    public void testByTextToBe() {
        // 1. Navigate to http://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        // 2. Click on Example 7
        driver.findElement(By.partialLinkText("Example 7")).click();

        WebElement alertArea = driver.findElement(By.id("alert"));
        System.out.println("alertArea.getText() = " + alertArea.getText());

        WebDriverWait wait = new WebDriverWait(driver, 6);
        // Wait for the image show up
        wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));
        // Here we had to relocate the element because the attribute has changed (color and stuff),
        // so driver cannot find it anymore
        // Element is not in the dom anymore error
        alertArea = driver.findElement(By.id("alert"));
        System.out.println("alertArea.getText() = " + alertArea.getText());
    }
}