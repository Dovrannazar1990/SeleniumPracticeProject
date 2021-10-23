package com.cybertek.tests.day09_explicit_wait_singleton_properties;

/*
 * We want this class only create one object
 * We want to block creation of more than one object
 *
 * Singleton is a design pattern to have a class only generate one object
 * in order to achieve Singleton pattern:
 *   1. private constructor
 *   2. private static field with data type same as class
 *   3. public getter method for private field
 *       to check if you have already created object
 *       if not --> create object for the first time
 *       if yes --> just use existing object
 */

public class Singleton {

    // static String word = "My only value";
    // Variable obj
    private static Singleton obj;

    private Singleton() {
    }

    public static Singleton getObj() {
        // if obj was not initially given value
        // create object and give value
        if (obj == null) {
            System.out.println("Object has not been created yet, creating one now");
            obj = new Singleton();
            return obj;
        } else {
            System.out.println("You already have object, use that existing object");
            return obj;
        }

    }

}