package com.algo.algorithm.modulo_division;

/*
Example: converting 23 (decimal) to binary (base 2):

23 / 2 = 11, remainder 1

11 / 2 = 5, remainder 1

5 / 2 = 2, remainder 1

2 / 2 = 1, remainder 0

1 / 2 = 0, remainder 1 <- and we stop because the quotient is now zero.

Now we compose the binary number by joining the remainders from bottom to top. We get: 10111.
 */
public class DecToBin {

    public static void dec2bin(int number) {
        int binaryNumber = 0, p = 1;
        while (number != 0) {
            binaryNumber = binaryNumber + p * (number % 2);
            number = number / 2;
            p = p * 10;
        }
        System.out.println(binaryNumber);
    }

    public static void main(String[] args) {
        dec2bin(23);
    }
}
