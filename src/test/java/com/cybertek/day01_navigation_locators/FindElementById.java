package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws InterruptedException {

        // Open chrome and navigate to yahoo
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");

        // Locate search box and enter selenium
        WebElement searchBox = driver.findElement(By.id("ybar-sbq"));

        // Enter text inside inputbox element using sendKey("your text")
        searchBox.sendKeys("Selenium");

        // Locate the search button and click (or submit)
        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        searchBtn.click();

        Thread.sleep(5000);
        // Quit browser
        driver.quit();
    }
}