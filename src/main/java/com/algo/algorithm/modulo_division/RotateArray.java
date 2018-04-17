package com.algo.algorithm.modulo_division;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

    public int[] rotateRight(int[] a, int k) {
        int len = a.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            ans[index] = a[i];
        }

        return ans;
    }

    public int[] rotateLeft(int[] a, int k) {
        int len = a.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i + len - k) % len;
            ans[index] = a[i];
        }

        return ans;
    }

    @Test
    public void test1() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotateRight(a, 3));
    }

    @Test
    public void test2() {
        int[] a = new int[]{1, 2, 3, 4};
        Assert.assertArrayEquals(new int[]{4, 1, 2, 3}, rotateRight(a, 1));
    }

    @Test
    public void test3() {
        int[] a = new int[]{1, 2, 3, 4};
        Assert.assertArrayEquals(new int[]{2, 3, 4, 1}, rotateLeft(a, 1));
    }

}
