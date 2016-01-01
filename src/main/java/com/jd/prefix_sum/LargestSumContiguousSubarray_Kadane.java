package com.jd.prefix_sum;

public class LargestSumContiguousSubarray_Kadane {

  public static void main(String[] args) {
    int[] a = {3, -1, -1, -1, -1, -1, 2, 0, 0, 0};
    // int[] a = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
    // int[] a = {-4, -3, -2, -1};
    findMaxSubArray(a);
    // System.out.println(maxSequenceSum(a));
  }

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
}
