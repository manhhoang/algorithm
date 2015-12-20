// Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k =
// 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know
// to solve this problem?

package com.jd.string_array;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

  public int[] solution(int[] a, int k) {
    int len = a.length;
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      int index = (i + k) % len;
      ans[index] = a[i];
    }

    return ans;
  }

  public int[] solution1(int[] a, int k) {
    int len = a.length;
    for (int i = 0; i < len; i++) {
      
    }
    return a;
  }

  @Test
  public void test1() {
    int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
    Assert.assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, solution(a, 3));
  }

  @Test
  public void test2() {
    int[] a = new int[] {1, 2, 3, 4};
    Assert.assertArrayEquals(new int[] {4, 1, 2, 3}, solution(a, 1));
  }

}
