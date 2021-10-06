package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByLinkText {

    public static void main(String[] args) throws InterruptedException {

        // Set up chrome driver, open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to https://www.google.com/
        driver.get("https://www.google.com/");

        // Try to identify search box using both name and id
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Everything is awesome");

        // Submit the search by clicking on the search button
        WebElement searchBtn = driver.findElement(By.name("btnK"));
        searchBtn.submit();

        // Navigate back to google home page
        driver.navigate().back();

        // Wait few second
        Thread.sleep(3000);

        // Click on about link
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();

        // Wait few seconds
        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }
}