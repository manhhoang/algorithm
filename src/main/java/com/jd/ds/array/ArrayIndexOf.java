package com.jd.ds.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIndexOf {

  static int indexOf(int[] source, int sourceCount, int[] target, int targetCount) {
    int first = target[0];
    int max = (sourceCount - targetCount);

    for (int i = 0; i <= max; i++) {
      /* Look for first item. */
      if (source[i] != first) {
        while (++i <= max && source[i] != first);
      }

      /* Found first item, now look at the rest of array */
      if (i <= max) {
        int j = i + 1;
        int end = j + targetCount - 1;
        int k = 1;
        while (j < end && source[j] == target[k]) {
          j++;
          k++;
        }

        if (j == end) {
          /* Found whole array. */
          return i;
        }
      }
    }
    return -1;
  }

  public static int solution(int[] arr, int[] subarr) {
    return indexOf(arr, arr.length, subarr, subarr.length);
  }

  @Test
  public void test1() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 5, 4}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(3, solution(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(0, solution(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2}));
  }

  @Test
  public void test6() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4}));
  }

  @Test
  public void test7() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5}));
  }

  @Test
  public void test8() {
    Assert.assertEquals(2, solution(new int[] {2, 3, 2, 4, 5}, new int[] {2, 4}));
  }

    public static class RotateArray {

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
}
