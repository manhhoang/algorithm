package com.jd.search;

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

    public static void main(String arr[]) {
        int[] a = {10, 34, 2, 56, 7, 67, 88, 42};
        boolean result = binarySearch(2, a);
        System.out.println(result);
    }
}
