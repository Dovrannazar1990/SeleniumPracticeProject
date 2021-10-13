package com.cybertek.tests.day06_junit_practice_utility_methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertFalseTest {

    @Test
    public void testNum() {

        int num = 10;

        // Write assertion to check the number is more than 9
        assertTrue(num > 9);

        // Write assertion to check the number is not less than 5
        assertTrue(!(num < 5));
        assertFalse(num < 5);
    }
}