package com.jd.combinatorial_enumeration;

public class Kadane_LargestSumContiguousSubarray {

  public static void main(String[] args) {
    int[] a = {3, -1, -1, -1, -1, -1, 2, 0, 0, 0};
    // int[] a = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
    // int[] a = {-6, -2, -3, -4, -1, -5, -5};
    findMaxSubArray(a);
  }

  public static void findMaxSubArray(int[] a) {

    int maxStartIndex = 0;
    int maxEndIndex = 0;
    int maxSum = Integer.MIN_VALUE;

    int cumulativeSum = 0;
    int maxStartIndexUntilNow = 0;

    for (int i = 0; i < a.length; i++) {
      cumulativeSum += a[i];
      if (cumulativeSum > maxSum) {
        maxSum = cumulativeSum;
        maxStartIndex = maxStartIndexUntilNow;
        maxEndIndex = i;
      } else if (cumulativeSum < 0) {
        maxStartIndexUntilNow = i + 1;
        cumulativeSum = 0;
      }
    }

    System.out.println("Max sum         : " + maxSum);
    System.out.println("Max start index : " + maxStartIndex);
    System.out.println("Max end index   : " + maxEndIndex);
  }
}
