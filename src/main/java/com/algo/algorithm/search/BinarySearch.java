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
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return true;
            }
            if (a[mid] < key) {
                low = mid + 1;
            }
            if (a[mid] > key) {
                high = mid - 1;
            }
        }
        return false;
    }

    public static int binarySearch1(int key, int[] a) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
