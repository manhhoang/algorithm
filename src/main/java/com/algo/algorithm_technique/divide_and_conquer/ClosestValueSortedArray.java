package com.algo.algorithm_technique.divide_and_conquer;

/**
 * Find the closest value in an sorted array.
 *
 * Input:
 * a = {-6, 2, 4, 7, 13, 36}
 * x = 5
 *
 * Output:
 * 4
 *
 */
public class ClosestValueSortedArray {

    private static double findClosest(int[] a, int x) {
        if(x < a[0]) {
            return a[0];
        }
        if(x > a[a.length-1]) {
            return a[a.length-1];
        }

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (x < a[mid]) {
                hi = mid - 1;
            } else if (x > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }
        // lo == hi + 1
        return (a[lo] - x) < (x - a[hi]) ? a[lo] : a[hi];
    }

    public static void main(String[] args) {
        int[] a = new int[]{-6, 2, 4, 7, 13, 36};
        System.out.println(findClosest(a, 5));
    }
}
