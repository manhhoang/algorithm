package com.algo.algorithm_technique.dynamic_programming.prefix_sum;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumNoAdjacent {

    public static int solution(int[] a) {
        int incl = a[0];
        int excl = 0;
        for (int i = 1; i < a.length; i++) {
            int excl_new = Math.max(incl, excl);
            incl = excl + a[i];
            excl = excl_new;
        }
        return Math.max(incl, excl);
    }

    @Test
    public void test1() {
        Assert.assertEquals(9, solution(new int[]{2, 3, 7, 5}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(14, solution(new int[]{4, 3, 5, 10}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(13, solution(new int[]{1, 3, 5, 10}));
    }

}
