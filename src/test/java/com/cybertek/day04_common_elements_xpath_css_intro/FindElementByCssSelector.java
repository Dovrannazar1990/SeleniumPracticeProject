package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByCssSelector {

    public static void main(String[] args) {

        // Open chrome, navigate here https://search.yahoo.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://search.yahoo.com/");

        // TODO: Identify search box using css selector
        // <input type="text" class="sbq" id="yschsp" name="p" value="" role="combobox">
        // Try different way, by id, by name
        // WebElement searchBox = driver.findElement(By.cssSelector("#yschsp"));
        // WebElement searchBox = driver.findElement(By.cssSelector("input[name='p']"));
        // WebElement searchBox = driver.findElement(By.cssSelector("input[id='yschsp']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='p'][type='text']"));
        searchBox.sendKeys("CSS SELECTOR");

        driver.quit();
    }
}