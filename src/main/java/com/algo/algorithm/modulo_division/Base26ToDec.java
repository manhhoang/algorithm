package com.algo.algorithm.modulo_division;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base26ToDec {

    public static int alphabetToDec(String letters) {
        int res = 0;
        for (Character c : letters.toCharArray()) {
            int d = c - 'A' + 1;
            res = 26 * res + d;
        }
        return res;
    }

    @Test
    public void test1() {
        assertEquals(1, alphabetToDec("A"));
    }

    @Test
    public void test2() {
        assertEquals(27, alphabetToDec("AA"));
    }

    @Test
    public void test3() {
        assertEquals(28, alphabetToDec("AB"));
    }

    @Test
    public void test4() {
        assertEquals(703, alphabetToDec("AAA"));
    }

    @Test
    public void test5() {
        assertEquals(704, alphabetToDec("AAB"));
    }
}
