package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByName {

    public static void main(String[] args) {

        // Open chrome and navigate to yahoo
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");

        // Identify yahoo search box by its name attribute
        // If the locator is wrong, it will throw NoSuchElementException
        WebElement searchBox = driver.findElement(By.name("p"));
        searchBox.sendKeys("Selenium");

        // Locate and click on the search button
        // It does not have name attribute so still have to use id
        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        // Any button can be clicked
        // Only the button to submit the form can use submit method
        searchBtn.submit();

        // Close browser
        driver.quit();
    }
}