package com.algo.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedArray {

    public static int[] solution(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int m = 0;

        // Compare elements at i and j
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[m] = first[i];
                i++;
            } else {
                result[m] = second[j];
                j++;
            }
            m++;
        }
        // Copy remaining elements
        System.arraycopy(first, i, result, m, first.length - i);
        System.arraycopy(second, j, result, m, second.length - j);
        return result;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 1, 2}, solution(new int[]{2}, new int[]{1, 1}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{1, 1, 1, 2, 3, 3, 4, 5}, solution(new int[]{1, 1, 3, 5}, new int[]{1, 2, 3, 4}));
    }


    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{-5, -1, 0, 1, 3, 3, 4, 5}, solution(new int[]{-1, 1, 3, 5}, new int[]{-5, 0, 3, 4}));
    }

}
