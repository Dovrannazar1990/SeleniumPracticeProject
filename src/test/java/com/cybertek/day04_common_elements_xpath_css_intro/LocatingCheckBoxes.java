package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingCheckBoxes {

    public static void main(String[] args) {

        // Checkboxes can be checked and unchecked
        // That's the only attribute special about the element
        // We can use additional method called isSelected() to determine if it's checked

        // Open chrome, navigate here http://practice.cybertekschool.com/checkboxes
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // Identify first checkbox
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        // Get attribute value of checked attribute. Shortcut: checkbox1.getAttribute("checked")).soutv and hit enter
        System.out.println("checkbox1.getAttribute(\"checked\") = " + checkbox1.getAttribute("checked"));

        WebElement checkbox2 = driver.findElement(By.id("box2"));
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
        System.out.println("checkbox2.getAttribute(\"checked\") = " + checkbox2.getAttribute("checked"));

        checkbox1.click(); // Currently, it's unchecked so clicking will check it
        checkbox2.click(); // Currently, it's checked so clicking will uncheck it

        // Check if it's not already checked then click on it
        if (!checkbox1.isSelected()){
            checkbox1.click();
        } else {
            System.out.println("Take it easy, already checked");
        }

        if (!checkbox2.isSelected()){
            checkbox2.click();
        } else {
            System.out.println("Take it easy, already checked");
        }

        // Close browser
        driver.quit();
    }
}