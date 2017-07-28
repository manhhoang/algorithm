package com.algo.algorithm_technique.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class IsPrime {

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        if (n == 2)
            return true;

        // check if n is a multiple of 2
        if (n % 2 == 0)
            return false;

        // if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Test
    public void test1() {
        Assert.assertFalse(isPrime(0));
    }

    @Test
    public void test2() {
        Assert.assertFalse(isPrime(1));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isPrime(2));
    }

    @Test
    public void test4() {
        Assert.assertTrue(isPrime(3));
    }

    @Test
    public void test5() {
        Assert.assertFalse(isPrime(4));
    }
}
