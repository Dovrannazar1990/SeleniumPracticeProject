package com.cybertek.tests.day06_driver_utility_testbase_alerts_tables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFormPracticeTest {

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

    @Test
    public void testLogin() {
        driver.get("http://practice.cybertekschool.com/login");
        //      //div/h2[text()='Login Page']
        WebElement header = driver.findElement(By.xpath("//div/h2[text()='Login Page']"));
        System.out.println("header.getText() = " + header.getText());

        // Css selector: input[name='username']
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");

        // Css selector: input[name='password']
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        //      //div[@id='flash']
        WebElement successMsg = driver.findElement(By.xpath("//div[@id='flash']"));
        String expectedResult = "You logged into a secure area!";
        // assertEquals(expectedResult, successMsg.getText());
        assertTrue(successMsg.getText().startsWith(expectedResult));

        /*
        //div[contains(text(),'You logged into a secure area!')]
        Use isDisplayed() method to check an element is displayed on the screen
        It's only used for an element that you have already identified
        */

        System.out.println("successMsg.isDisplayed() = " + successMsg.isDisplayed());

        String xpathStr = "//div[contains(text(),'You logged into a secure area!')]";
        WebElement successMsg2 = driver.findElement(By.xpath(xpathStr));
        assertTrue(successMsg2.isDisplayed());
    }
}