package com.cybertek.tests.day06_junit_practice_utility_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class IsDisplayedPracticeTest {

    WebDriver driver;

    @BeforeEach
    public void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    // Navigate to the form page http://practice.cybertekschool.com/registration_form
    // Identify the error message exists but not displayed
    // Enter text "a" and check the error message displayed
    /*
    small[data-bv-for='firstname'][data-bv-validator='stringLength']
    //small[.='first name must be more than 2 and less than 64 characters long']
     */

    @Test
    public void testErrorMessage(){

        driver.get("http://practice.cybertekschool.com/registration_form");
        String xpathForErrorMsg = "//small[.='first name must be more than 2 and less than 64 characters long']";
        // This element exists in html but it's hidden not displayed on the screen
        // It will only display when there is an input validation error like less than 2 or more than 64 chars in this case
        // So isDisplayed method will return false
        WebElement strLengthErrorElement = driver.findElement(By.xpath(xpathForErrorMsg));
        System.out.println("strLengthErrorElement.isDisplayed() = " + strLengthErrorElement.isDisplayed());
        assertTrue(!strLengthErrorElement.isDisplayed());
        assertFalse(strLengthErrorElement.isDisplayed());

        // Now we are entering something invalid: less than 2 characters
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys("a");

        // Now the error message should show up
        System.out.println("strLengthErrorElement.isDisplayed() = " + strLengthErrorElement.isDisplayed());
        assertTrue(strLengthErrorElement.isDisplayed());
    }
}