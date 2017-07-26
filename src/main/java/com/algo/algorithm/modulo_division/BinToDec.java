package com.algo.algorithm.modulo_division;

/*
To convert bin to dec number we count all the integers in the binary number (we have 5). We write from right to left the first 5 powers of two, starting with the power zero:

24    23    22    21    20. Now we multiply each of these numbers with their respective from the original binary number: 10111. Then we add each pair. We get:

24 * 1  +  23 * 0  +  22 * 1  +  21 * 1  +  20 * 1. We calculate this as usual: 16 * 1 + 8 * 0 + 4 * 1 + 2 * 1 + 1 * 1 => 16 + 0 + 4 + 2 + 1 = 23.
 */
public class BinToDec {

    public static void bin2dec(int number) {
        int decNumber = 0;
        int nexInt;
        int i = 0;
        while (number != 0) {
            nexInt = number  % 10;
            decNumber = (int) (decNumber + nexInt * Math.pow(2, i));
            number = number / 10;
            i++;
        }
        System.out.println(decNumber);
    }

    public static void main(String[] args) {
        bin2dec(10111);
    }
}
