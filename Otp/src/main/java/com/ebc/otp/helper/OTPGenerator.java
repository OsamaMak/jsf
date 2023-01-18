package com.ebc.otp.helper;

import java.util.Random;

public class OTPGenerator {

    public static String GENERATE_SIMPLE_OTP(final int len) {

        // Using numeric values
        String numbers = "0123456789";
        // Using random method
        Random random = new Random();
        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return String.valueOf(otp);
    }

    /*
        A complex OTP has Cap_chars, Lower_chars, and numeric value.
        So we are using all of them to generate our OTP
    */
    public static String GENERATE_COMPLEX_OTP(final int len) {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        String values = Capital_chars + Small_chars + numbers;
        // Using random method
        Random random = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] = values.charAt(random.nextInt(values.length()));

        }
        return new String(otp);
    }
}
