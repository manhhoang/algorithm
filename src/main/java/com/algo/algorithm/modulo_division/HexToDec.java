package com.algo.algorithm.modulo_division;

/*
Converting from hex to dec number 7DF:

As you know in hexadecimal numbers go from 0 to 16: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F. This means 7DF is equal in decimal to:
162 * 7  +  161 * D  +  100 * F = 162 * 7  +  161 * 13  +  160 * 15 => 256 * 7 + 16 * 13 + 1 * 15 => 2015.

 */
public class HexToDec {

    public static void hex2dec(String hex) {
        int number = Integer.parseInt(hex, 16);
        System.out.println(number);
    }

    public static void main(String[] args) {
        hex2dec("7DF");
    }
}
