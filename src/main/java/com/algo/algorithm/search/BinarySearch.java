package com.algo.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearch {

    public static boolean binarySearch(int key, int[] a) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (a[middle] == key) {
                return true;
            }
            if (a[middle] < key) {
                low = middle + 1;
            }
            if (a[middle] > key) {
                high = middle - 1;
            }
        }
        return false;
    }

    public static int binarySearch1(int key, int[] a) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (a[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        if(a[low] == key)
            return low;
        return -1;
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, binarySearch(5, new int[]{1, 2, 5, 9, 9}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, binarySearch1(5, new int[]{1, 2, 5, 9, 9}));
    }

}
