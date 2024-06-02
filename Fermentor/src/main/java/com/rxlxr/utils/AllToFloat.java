package com.rxlxr.utils;

public class AllToFloat {

    public static Float convertToFloat(Object input) {
        if (input instanceof Integer) {
            return ((Integer) input).floatValue();
        } else if (input instanceof Double) {
            return ((Double) input).floatValue();
        } else if (input instanceof Long) {
            return ((Long) input).floatValue();
        } else if (input instanceof Float) {
            return (Float) input; // Already a Float
        } else if (input instanceof String) {
            try {
                return Float.parseFloat((String) input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Input string is not a valid float number: " + input);
            }
        } else {
            throw new IllegalArgumentException("Unsupported type: " + input.getClass().getName());
        }
    }
}
