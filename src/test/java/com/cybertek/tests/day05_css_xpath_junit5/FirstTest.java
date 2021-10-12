package com.cybertek.tests.day05_css_xpath_junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Test class name should be sth like this
// SomethingTest.java
// TestSomething.java
// SomethingShouldDoThatTest.java

Test method: testAddition()
             additionTest()
 */

public class FirstTest {
    // Test method is annotated with @Test annotation
    // It's a void method with no parameter

    @Test
    public void testAddition() {

        int num1 = 10;
        int num2 = 7;
        int expectedResult = 17;
        Assertions.assertEquals(expectedResult, num1 + num2);
    }

    @Test
    public void testString() {

        String msg = "I love Selenium";
        // Assert this msg equal "I love Selenium"
        // Below assertEquals method accepts 2 parameters
        Assertions.assertEquals("I love Selenium", msg);
        // Assert this msg starts with "I love"
        // Below assertTrue method accepts 1 parameter as boolean
        Assertions.assertTrue(msg.startsWith("I love"));
    }
}