package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class ActionsClassTest extends TestBase {

    @Test
    public void testHoverAction() {

        /*
         * //img[1]
         * (//div[@class= 'figure']/img)[1]
         */
        driver.get("http://practice.cybertekschool.com/hovers");

        // Locate first image and hover over to the image
        WebElement img1Elm = driver.findElement(By.xpath("(//div[@class= 'figure']/img)[1]"));

        // Create instance of Actions class by passing driver object
        // It's coming from here import org.openqa.selenium.interactions.Actions;
        Actions actions = new Actions(driver);
        actions.moveToElement(img1Elm).perform();

        BrowserUtil.waitFor(3);

        // Verify user profile 1 displayed with text "name: user1"
        WebElement firstProfileElm = driver.findElement(By.xpath("//h5[.='name: user1']"));
        assertTrue(firstProfileElm.isDisplayed());

        // Locate second image and hover over to the image
        WebElement img2Elm = driver.findElement(By.xpath("(//div[@class= 'figure']/img)[2]"));
        actions.moveToElement(img2Elm).perform();

        BrowserUtil.waitFor(3);

        /*
         * Perform these actions in this sequence:
         *  Hover over to 1st image, pause 2 seconds, and then second image pause 2 seconds
         *  Then hover over to 1st image again, pause 2 seconds, and then second image pause 2 seconds
         * PERFORM THE ACTION!!!
         */
        actions.moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
                .moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
                .perform();

        // TODO: Homework: get a List<WebElement> containing those 3 images. Iterate over the list to hover over and verify the text


    }

    @Test
    public void testDragAndDrop() {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtil.waitFor(2);

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement biggerCircle = driver.findElement(By.id("droptarget"));

        // dragAndDrop method of Actions class, accept 2 webElement and drop first one into second one
        Actions actions = new Actions(driver);
        actions.dragAndDrop(smallCircle, biggerCircle).perform();

        BrowserUtil.waitFor(3);

        // Verify the big circle text has changed to "You did great!"
        assertEquals("You did great!", biggerCircle.getText());
    }

    // As long as you can hold down to SHIFT and Type something
    // Then release the shift and perform the action
    // That's all we need.
    @Test
    public void testKeyboardAction() {

        /*
         * Navigate to https://www.google.com
         * Hold down to shift enter text "i love selenium". YOU SHOULD SEE UPPERCASE
         * Release the shift
         * Enter text "i love selenium"
         * Hold down to command on Mac, control on Windows and enter "A"
         * Release the command or control key
         * Then hit backspace to delete
         */
        driver.get("https://www.google.com");
        // Locate searchBox using name value q
        WebElement searchBox = driver.findElement(By.name("q"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        /**
         * keyDown method for holding down to certain modifier key like Control, SHIFT and so on
         * keyUp method for releasing what you are holding down to
         * sendKeys method of Actions class is for pressing key that provided
         * pause method of Actions class is for pausing in between actions in milliseconds
         */
        // This is way more than enough
//        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium")
//                .pause(2000).keyUp(Keys.SHIFT)
//                .sendKeys("i love selenium").pause(2000)
//                .keyDown(Keys.COMMAND).sendKeys("A") // command+a on Mac will select all text
//                .perform();

        // This is way more than enough to demonstrate you can take any keyboard action
        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium")
                .pause(2000).keyUp(Keys.SHIFT)
                .sendKeys("i love selenium").pause(2000)
                .keyDown(Keys.COMMAND).sendKeys("A") // command+a on Mac will select all text
                // .keyDown(Keys.CONTROL).sendKeys("A") // control+a on Windows will select all text
                .keyUp(Keys.COMMAND).pause(2000)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }

    @Test
    public void testDoubleClick() {

        /*
         * Navigate here
         * //https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick
         * Double-click on paragraph with text "Double-click this paragraph to trigger a function."
         * Then assert the new paragraph with text "Hello world" displayed right under
         * Both of the elements are under iframe with id iframeResult
         */
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        BrowserUtil.waitFor(2);
        // Both elements are under the frame, so switch into it first
        driver.switchTo().frame("iframeResult");
        WebElement pElm1 = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));
        // In order to double-click we will use actions class
        Actions actions = new Actions(driver);
        actions.doubleClick(pElm1).perform(); // This is how we double-click
        BrowserUtil.waitFor(2);
        // TODO: go ahead and assert the "Hello World" showed up



    }
}