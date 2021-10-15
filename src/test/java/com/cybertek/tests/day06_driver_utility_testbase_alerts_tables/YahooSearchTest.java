package com.cybertek.tests.day06_driver_utility_testbase_alerts_tables;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class YahooSearchTest extends TestBase {

    @Test
    public void testYahooSearchHomePage() {
        driver.get("https://search.yahoo.com/");
        String expectedTitle = "Yahoo Search - Web Search";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testYahooSearchResultPage() {
        // Navigate to yahoo search, enter selenium and hit enter
        driver.get("https://search.yahoo.com/");
        driver.findElement(By.name("p")).sendKeys("selenium" + Keys.ENTER);
        // Assert title starts with selenium
        assertTrue(driver.getTitle().startsWith("selenium"));
    }
}