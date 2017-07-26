package com.algo.algorithm.modulo_division;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntToLetters {

    public static String intToLetters(int value) {
        String result = "";
        while (--value >= 0) {
            result = (char) ('A' + value % 26) + result;
            value /= 26;
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals("A", intToLetters(1));
    }

    @Test
    public void test2() {
        assertEquals("AA", intToLetters(27));
    }
    @Test
    public void test3() {
        assertEquals("AB", intToLetters(28));
    }

    @Test
    public void test4() {
        assertEquals("AAA", intToLetters(703));
    }

    @Test
    public void test5() {
        assertEquals("AAB", intToLetters(704));
    }
}
