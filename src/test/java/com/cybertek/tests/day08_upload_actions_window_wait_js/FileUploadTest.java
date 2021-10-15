package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest extends TestBase {

    @Test
    public void testUpload() {

        driver.get("http://practice.cybertekschool.com/upload");

        /*
         * Locate the input field:
         *  By.id("file-upload")
         *  By.xpath("//input[@id='file-upload']")
         *  By.cssSelector("input[id='file-upload']") or
         *                  #file-upload
         */

        WebElement fileInputField = driver.findElement(By.id("file-upload"));

        /*
         * Find the full path of your file in your computer and send key into above input field
         * You can copy the full path of file by:
         *  right click and hold down to option key and select --> copy "yourfilename" as path
         * It will copy the full path of your file
         */

        String filePath = "/Users/dovran/Desktop/HTML_Class/torino.jpg";
        fileInputField.sendKeys(filePath);

        /*
         * #file-submit
         * //input[@id='file-submit']
         * input[value='Upload'][type='submit']
         */

        driver.findElement(By.id("file-submit")).click();
        // Optionally assert "File Uploaded!" success message showed up
        // Thread.sleep(2000);
        BrowserUtil.waitFor(2);

        // Success message page: //h3[.='File Uploaded!']
        WebElement successMsg = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        assertTrue(successMsg.isDisplayed());

        /*
         * Thread.sleep(2000); is needed sometimes, but we are forced to deal with checked exception
         * Objective: have a human-readable utility method, so we can call like this
         * BrowserUtil.waitFor(2); ---> no exception handling just wait for 2 seconds
         * Create a class called BrowserUtil under utility package
         * Create a static void method called waitFor accept int as second to wait
         */
    }
}