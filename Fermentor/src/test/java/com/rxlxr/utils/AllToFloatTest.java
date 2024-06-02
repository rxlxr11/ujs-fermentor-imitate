package com.rxlxr.utils;

import static com.rxlxr.utils.AllToFloat.convertToFloat;
import static org.junit.jupiter.api.Assertions.*;

class AllToFloatTest {
    public static void main(String[] args) {
        System.out.println(convertToFloat(42));              // Integer to Float
        System.out.println(convertToFloat(42.5));            // Double to Float
        System.out.println(convertToFloat(42L));             // Long to Float
        System.out.println(convertToFloat("42.5"));          // String to Float
        System.out.println(convertToFloat(42.5f));           // Float to Float
        System.out.println(convertToFloat(42.5d));           // Double to Float
        System.out.println(convertToFloat("42"));            // String to Float
        System.out.println(convertToFloat(42.0));            // Double to Float
    }

}