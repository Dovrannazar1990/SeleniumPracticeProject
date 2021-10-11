package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByXPath_Intro {

    public static void main(String[] args) {

        // XPath can be used to navigate through elements and attributes in a html document.
        // Inspect element ---> right click ---> copy ---> copy full xpath
        //         /html/body/div/div[2]/div/div/div/h1/span
        // This is known as absolute xpath,
        // starting from root element (html) till the element you are looking for
        //      //h1/span  this is known as relative xpath, it starts with double forward slash //

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        // Using above full (absolute) xpath to identify the element and get the text
        WebElement headerSpan = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/h1/span"));
        System.out.println("headerSpan.getText() = " + headerSpan.getText());

        // Use relative path    //h1/span ---> start looking for the element with h1
        // whoever parents or grandparents are
        // find direct child with span tag
        WebElement headerSpan2 = driver.findElement(By.xpath("//h1/span"));
        System.out.println("headerSpan2.getText() = " + headerSpan2.getText());

        // Providing attributes in xpath
        // elementTag[@attributeName='attribute value']
        //  //input[@name='checkbox1']
        //  //input[@id='box1']
        // If you have more than one
        // elementTag[@attributeName='attribute value' and @attributeName='attribute2 value']
        //  //input[@name='checkbox1' and @type='checkbox']
        // You have option to provide index
        //  //someElement[indexGoesHere]
        // You can also provide use text() xpath function
        //  //elementTag[text()='some text value goes here']
        //  //h3[text()='Checkboxes']

        // Click on checkboxes link to go to checkbox page using xpath
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();

        // Identify header, 1st checkbox using xpath
        WebElement header = driver.findElement(By.xpath("//h3[text()='Checkboxes']"));
        System.out.println("header.getText() = " + header.getText());

        WebElement firstCheckbox = driver.findElement(By.xpath("//input[@id='box1']"));
        System.out.println("firstCheckbox.isSelected() = " + firstCheckbox.isSelected());

        // String abc = "bla bla 'some more bla here' bla ended";

        driver.quit();
    }
}