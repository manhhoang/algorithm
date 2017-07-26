package com.algo.algorithm.modulo_division;

public class DecToHex {

    public static void decToHex(int number) {
        int hexNumber = 0x0, p = 1;
        while (number != 0) {
            hexNumber = hexNumber + p * (number % 16);
            number = number / 16;
            p = p * 16;
        }
        System.out.println(Integer.toHexString(hexNumber));
    }

    public static void main(String[] args) {
        decToHex(2015);
    }
}
