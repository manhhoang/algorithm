package com.algo.algorithm_technique.dp.prefix_sum;

import org.junit.Assert;
import org.junit.Test;

public class LargestSumContiguousSubarray_Kadane {

    public static int maxSequenceSum(int[] a) {
        int maxSoFar = a[0];
        int maxEndingHere = a[0];

        for (int i = 1; i < a.length; i++) {
      /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = a[i];
            else
                maxEndingHere += a[i];

      /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }

    public static void findMaxSubArray(int[] a) {
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxSum = Integer.MIN_VALUE;

        int cumulativeSum = 0;
        int maxStartIndexUntilNow = 0;

        for (int i = 0; i < a.length; i++) {
            if (cumulativeSum < 0) {
                maxStartIndexUntilNow = i;
                cumulativeSum = a[i];
            } else {
                cumulativeSum += a[i];
            }

            if (cumulativeSum > maxSum) {
                maxSum = cumulativeSum;
                maxStartIndex = maxStartIndexUntilNow;
                maxEndIndex = i;
            }
        }

        System.out.println("Max sum         : " + maxSum);
        System.out.println("Max start index : " + maxStartIndex);
        System.out.println("Max end index   : " + maxEndIndex);
    }

    public static int maxSequenceSumIgnoreZero(int[] a) {
        int maxSoFar = a[0];
        int maxEndingHere = a[0];

        for (int i = 1; i < a.length; i++) {
            if (maxEndingHere < 0 || a[i] == 0)
                maxEndingHere = a[i];
            else
                maxEndingHere += a[i];

            if (maxEndingHere >= maxSoFar && maxEndingHere != 0 || maxSoFar == 0)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }

    @Test
    public void test1() {
        int[] a = {-3, -1, -1, -1, 0, -1, -2, 0, 0, 0};
        Assert.assertEquals(0, maxSequenceSum(a));
        Assert.assertEquals(-1, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test2() {
        int[] a = {-3, -1, -1, 1, 0, 1, 4, 0, 0, 0};
        Assert.assertEquals(6, maxSequenceSum(a));
        Assert.assertEquals(5, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test3() {
        int[] a = {3, -1, -1, -1, 0, -1, -2, 0, 0, 0};
        Assert.assertEquals(3, maxSequenceSum(a));
        Assert.assertEquals(3, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test4() {
        int[] a = {0, -1, 0};
        Assert.assertEquals(0, maxSequenceSum(a));
        Assert.assertEquals(-1, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test5() {
        int[] a = {0, 0, 0};
        Assert.assertEquals(0, maxSequenceSum(a));
        Assert.assertEquals(0, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test6() {
        int[] a = {3, 4, 0, 1, 2};
        Assert.assertEquals(10, maxSequenceSum(a));
        Assert.assertEquals(7, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test7() {
        int[] a = {-1, 0, 0};
        Assert.assertEquals(0, maxSequenceSum(a));
        Assert.assertEquals(-1, maxSequenceSumIgnoreZero(a));
    }

    @Test
    public void test8() {
        int[] a = {0, 0, -1};
        Assert.assertEquals(0, maxSequenceSum(a));
        Assert.assertEquals(-1, maxSequenceSumIgnoreZero(a));
    }
}
