package com.algo.algorithm_technique.divide_and_conquer;

/**
 * Find k largest element in an unsorted array by using QuickSelect, partition in Quick sort.
 *
 * Input:
 * a = {1, 3, 5, 2, 4}
 * k = 0
 * k = 1
 * Output:
 * 5
 * 4
 *
 */
public class KLargestElement {

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while (a[++i] < v)
                if (i == hi)
                    break;

            // find item on hi to swap
            while (v < a[--j])
                if (j == lo)
                    break;

            if (i >= j) // check if pointers cross
                break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static int select(int[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if (i > k)
                hi = i - 1;
            else if (i < k)
                lo = i + 1;
            else
                return a[i];
        }
        return a[lo];
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 2, 4};
        int k = 0;
        int ith = select(a, k);
        System.out.println(ith); // print 5
    }
}
