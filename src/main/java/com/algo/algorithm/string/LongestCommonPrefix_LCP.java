package com.algo.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefix_LCP {

    public String solve(String[] a) {
        String s = "";
        int j = 0;
        boolean stop = false;
        while (!stop) {
            if (j >= a[0].length()) {
                break;
            }
            char ch = a[0].charAt(j);
            s += ch;
            for (int i = 1; i < a.length; i++) {
                if (j >= a[i].length() || a[i].charAt(j) != ch) {
                    stop = true;
                    s = s.substring(0, s.length() - 1);
                    break;
                }
            }
            j++;
        }
        return s;
    }

    @Test
    public void test1() {
        Assert.assertEquals("ab", solve(new String[]{"abcd", "abd"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals("a", solve(new String[]{"abcd", "acd"}));
    }

    @Test
    public void test3() {
        Assert.assertEquals("ab", solve(new String[]{"abcd", "ab", "abe"}));
    }

    @Test
    public void test4() {
        Assert.assertEquals("ab", solve(new String[]{"ab", "abc"}));
    }

    @Test
    public void test5() {
        Assert.assertEquals("a", solve(new String[]{"a", "ab", "abc", "abcd"}));
    }

}
