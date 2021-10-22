package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ExplicitWait2Test extends TestBase {

    @Test
    public void waitUntilElementIntractable() {

        driver.get("https://practice.cybertekschool.com/dynamic_controls");

        // elementToBeClickable(By locator)
        // elementToBeClickable(WebElement element)
        // An expectation for checking an element is visible and enabled such that you can click it

        WebElement inputField = driver.findElement(By.cssSelector("form#input-example>input"));
        System.out.println("inputField.isEnabled() = " + inputField.isEnabled());
        // Click on enable button and wait until the inputBox is enabled clickable
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        // This will wait for 7 second max for input element located by cssSelector("form#input-example>input")
        // enabled, interactive, visible
        // wait.until(elementToBeClickable(By.cssSelector("form#input-example>input")));
        wait.until(elementToBeClickable(inputField));

        // Now enter something into the input field
        inputField.sendKeys("Hello World!");
        BrowserUtil.waitFor(5);
    }
}