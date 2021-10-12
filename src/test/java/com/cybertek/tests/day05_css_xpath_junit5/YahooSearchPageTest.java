package com.cybertek.tests.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahooSearchPageTest {

    // Write 2 tests:
    // testYahooSearchHomePageTitle

    // Test when you navigate to yahoo search page
    // The title should be "Yahoo Search - Web Search"

    @Test
    public void testYahooSearchHomePageTitle() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://search.yahoo.com/");

        String expectedTitle = "Yahoo Search - Web Search";
        String actualTitle = driver.getTitle();

        // Quit the browser here, because we already saved the title
        driver.quit();
        // Do static import, so you can do this
        // import static org.junit.jupiter.api.Assertions.assertEquals;
        assertEquals(expectedTitle, actualTitle);
    }

    // Test method name: testYahooSearchResultPageTitle
    // Test navigate to yahoo page
    // And search for Selenium
    // The page title should start with selenium
    @Test
    public void testYahooSearchResultPageTitle() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://search.yahoo.com/");

        // Identify search box and enter selenium, and hit Enter key on keyboard
        WebElement searchBox = driver.findElement(By.xpath("//div/input[@name='p' and @id='yschsp']"));
        // We can simulate keystroke using Keys.SELECT_ONE_OF_THE_OPTION
        // In this case we are typing selenium and hitting Enter
        searchBox.sendKeys("Selenium" + Keys.ENTER);

        String expectedTitleStartWith = "Selenium";
        String actualTitle = driver.getTitle();
        // Quit the browser
        driver.quit();
        // Assert the title starts with Selenium
        assertTrue(actualTitle.startsWith("Selenium"));
    }
}