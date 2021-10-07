package com.cybertek.day03_locate_by_tag_class_getAtt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementByTagName {

    public static void main(String[] args) {

        /*
        * Purple: tag name
        * Orange: attribute name
        * Blue: attribute value
        * Black: text
        */

        // Open chrome and navigate to practice site
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // Identify first element with tag name <a>
        WebElement firstLnk = driver.findElement(By.tagName("a"));

        // Now lets get the text to find out
        System.out.println("firstLnk.getText() = " + firstLnk.getText());

        // What if I wanted to find and store all elements with <a> tag ---> findElements
        List<WebElement> allATagElements = driver.findElements(By.tagName("a"));
        // allATagElements.size().soutv and hit enter
        System.out.println("allATagElements.size() = " + allATagElements.size());

        // Iterate over this list, get the text of the link, get attribute and print them out
        // allATagElements.iter and hit enter, give a name to each element
        for (WebElement eachElement : allATagElements) {
            System.out.println("eachElement.getText() = " + eachElement.getText());
            System.out.println("eachElement.getAttribute(\"href\") = " + eachElement.getAttribute("href"));
        }

    }
}