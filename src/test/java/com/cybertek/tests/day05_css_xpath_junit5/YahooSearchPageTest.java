package com.cybertek.tests.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahooSearchPageTest {

    WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @AfterAll
    public static void teardown() {
        System.out.println("@AfterAll, nothing to do here");
    }

    // Write 2 tests:
    // testYahooSearchHomePageTitle

    // Test when you navigate to yahoo search page
    // The title should be "Yahoo Search - Web Search"

    @Test
    public void testYahooSearchHomePageTitle() {

        driver.get("https://search.yahoo.com/");
        String expectedTitle = "Yahoo Search - Web Search";
        String actualTitle = driver.getTitle();

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

        driver.get("https://search.yahoo.com/");

        // Identify search box and enter selenium, and hit Enter key on keyboard
        WebElement searchBox = driver.findElement(By.xpath("//div/input[@name='p' and @id='yschsp']"));
        // We can simulate keystroke using Keys.SELECT_ONE_OF_THE_OPTION
        // In this case we are typing selenium and hitting Enter
        searchBox.sendKeys("Selenium" + Keys.ENTER);

        String expectedTitleStartWith = "Selenium";
        String actualTitle = driver.getTitle();

        // Assert the title starts with Selenium
        assertTrue(actualTitle.startsWith("Selenium"));
    }
}