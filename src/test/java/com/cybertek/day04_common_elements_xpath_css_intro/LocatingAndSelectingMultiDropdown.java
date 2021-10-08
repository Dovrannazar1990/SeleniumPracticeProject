package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatingAndSelectingMultiDropdown {

    public static void main(String[] args) {

        // Open chrome and navigate to dropdown practice url
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // Identify language multi select dropdown
        WebElement langDropdownElm = driver.findElement(By.name("Languages"));

        // Wrap it up using Select class, so we can use easy methods
        Select langSelectObj = new Select(langDropdownElm);

        // Call all available methods
        System.out.println("langSelectObj.isMultiple() = " + langSelectObj.isMultiple());
        langSelectObj.selectByIndex(1);
        langSelectObj.selectByValue("c");
        langSelectObj.selectByVisibleText("Java");
        // At this moment 3 options are selected at the same time

        // Now deselect
        langSelectObj.deselectByIndex(1);
        langSelectObj.deselectByValue("c");
        langSelectObj.deselectByVisibleText("Java");

        // deselect all
        langSelectObj.deselectAll();

        driver.quit();
    }
}