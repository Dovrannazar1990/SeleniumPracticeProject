package com.cybertek.day03_locate_by_tag_class_getAtt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementAttribute {

    public static void main(String[] args) {

        // Set up chrome driver and open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // Get the first link on the page and get href attribute
        WebElement firstLink = driver.findElement(By.linkText("A/B Testing"));

        // Get text practice
        System.out.println("firstLink.getText() = " + firstLink.getText());

        // Get any attribute of identified element, in this case href
        System.out.println("firstLink.getAttribute(\"href\") = " + firstLink.getAttribute("href"));

        driver.quit();
    }
}