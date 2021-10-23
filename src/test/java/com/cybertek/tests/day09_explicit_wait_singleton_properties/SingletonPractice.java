package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.Driver;
import org.junit.jupiter.api.Test;

public class SingletonPractice {

    @Test
    public void testOutDriverUtility() {

        Driver.getDriver();
        Driver.getDriver();
        Driver.getDriver();
        Driver.getDriver();
    }

    @Test
    public void testSingleton() {

//        Singleton s1 = new Singleton();
//        s1.word = "abc";
//
//        Singleton s2 = new Singleton();
//        s2.word = "abc";

        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();

        /*
         * Object has not been created yet, creating one now
         * You already have object, use that existing object
         * You already have object, use that existing object
         * You already have object, use that existing object
         * You already have object, use that existing object
         */

    }

}