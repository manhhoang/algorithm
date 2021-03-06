/******************************************************************************
 * Compilation: javac Euclid.java Execution: java Euclid p q
 *
 * Reads two command-line arguments p and q and computes the greatest common divisor of p and q
 * using Euclid's algorithm.
 *
 * Remarks ----------- - may return the negative of the gcd if p is negative
 *
 ******************************************************************************/

package com.algo.algorithm_technique.recursive_programming;

import com.algo.algorithm.util.StdOut;

public class GCD_Euclid {
    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        else
            return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = 10;
        int q = 8;
        int d = gcd(p, q);
        int d2 = gcd2(p, q);
        StdOut.println("gcd(" + p + ", " + q + ") = " + d);
        StdOut.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
