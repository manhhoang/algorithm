package com.jd.dp;

// Kadane’s Algorithm
public class LargestSumContiguousSubarray {

  private static int maxSubArraySum(int[] a, int N) {
    int max_so_far = 0;
    int max_ending_here = 0;
    for (int i = 0; i < N; i++) {
      max_ending_here += a[i];
      if (max_ending_here < 0)
        max_ending_here = 0;
      max_so_far = Math.max(max_ending_here, max_so_far);
    }
    return max_so_far;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(maxSubArraySum(a, a.length));
  }

}
