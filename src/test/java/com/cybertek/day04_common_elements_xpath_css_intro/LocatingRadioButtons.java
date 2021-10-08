package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatingRadioButtons {

    public static void main(String[] args) {

        // Radio buttons can be checked and usually come in group
        // That's the only attribute special about the element
        // We can use additional method called isSelected() to determine if it's checked

        // Open chrome navigate here http://practice.cybertekschool.com/radio_buttons
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // Locate the blue radio button
        WebElement blueRadio = driver.findElement(By.id("blue"));
        System.out.println("blueRadio.isSelected() = " + blueRadio.isSelected()); // true because it's already selected
        blueRadio.click(); // Nothing will happen because it is already selected

        WebElement redRadio = driver.findElement(By.id("red"));
        System.out.println("before click redRadio.isSelected() = " + redRadio.isSelected());
        redRadio.click(); // This will click to check radio button
        System.out.println("after click redRadio.isSelected() = " + redRadio.isSelected());

        // Check blue radio button status
        System.out.println("after red is clicked blueRadio.isSelected() = " + blueRadio.isSelected());

        WebElement greenRadio = driver.findElement(By.id("green"));
        greenRadio.click(); // Nothing will happen
        System.out.println("greenRadio.isSelected() = " + greenRadio.isSelected());
        // Any element can use isEnabled() method to check whether element is disabled or not
        // One can not take any action on disabled element
        System.out.println("greenRadio.isEnabled() = " + greenRadio.isEnabled());

        // A radio group is grouped by its name attribute
        // All radio buttons related to color has name color in this case
        // So we can findElements to get all of them
        List<WebElement> allColorRadios = driver.findElements(By.name("color"));

        // Check the size to see how many radio button identified
        System.out.println("allColorRadios.size() = " + allColorRadios.size());

        // Click on 3rd radio button
        allColorRadios.get(2).click();

        // Loop over all the elements to print these: id attribute, isSelected, isEnabled
        // allColorRadios.iter and hit enter, then give each element a name
        for (WebElement eachColorRadio : allColorRadios) {
            System.out.println("eachColorRadio.getAttribute(\"id\") = " + eachColorRadio.getAttribute("id"));
            System.out.println("eachColorRadio.isSelected() = " + eachColorRadio.isSelected());
            System.out.println("eachColorRadio.isEnabled() = " + eachColorRadio.isEnabled());
            System.out.println("---------------------------------------------");
        }

        // Close browser
        driver.quit();
    }
}