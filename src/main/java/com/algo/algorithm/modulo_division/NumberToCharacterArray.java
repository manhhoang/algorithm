package com.algo.algorithm.modulo_division;

import org.junit.Assert;
import org.junit.Test;

public class NumberToCharacterArray {

    public static String solution(int n) {
        if (n < 10)
            System.out.println(n);
        else {
            solution(n / 10);
            System.out.println(n % 10);
        }
        return "";
    }

    @Test
    public void test1() {
        Assert.assertEquals("", solution(1));
    }

    @Test
    public void test2() {
        Assert.assertEquals("", solution(1234));
    }
}
