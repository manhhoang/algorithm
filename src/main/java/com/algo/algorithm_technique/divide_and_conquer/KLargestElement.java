package com.algo.algorithm_technique.divide_and_conquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find k largest element in an unsorted array by using QuickSelect, partition in Quick sort.
 *
 * Input:
 * a = {1, 3, 5, 2, 4}
 * k = 1
 * k = 2
 * Output:
 * 5
 * 4
 *
 */
public class KLargestElement {

    // O(nlogn) running time + O(1) memory
    public static int findKthLargest1(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // O(nlogk) running time + O(k) memory
    public static int findKthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            // find item on lo to swap
            while (a[++i] < a[lo])
                if (i == hi)
                    break;

            // find item on hi to swap
            while (a[lo] < a[--j])
                if (j == lo)
                    break;

            if (i >= j) // check if pointers cross
                break;

            exch(a, i, j);
        }

        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static int select(int[] a, int k) {
        if (k < 0 || k > a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        k = a.length - k;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int i = partition(a, lo, hi);
            if (i < k)
                lo = i + 1;
            else if (i > k)
                hi = i - 1;
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
        int k = 1;
        System.out.println(findKthLargest1(a, k));
        System.out.println(findKthLargest2(a, k));
        System.out.println(select(a, k));
    }
}
