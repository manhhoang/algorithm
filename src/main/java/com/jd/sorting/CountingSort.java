package com.jd.sorting;

import org.junit.Assert;
import org.junit.Test;

public class CountingSort {

  public int[] solution(int[] a, int min, int max) {
    int[] count = new int[max - min + 1];
    for (int number : a) {
      count[number - min]++;
    }
    int z = 0;
    for (int i = min; i <= max; i++) {
      while (count[i - min] > 0) {
        a[z] = i;
        z++;
        count[i - min]--;
      }
    }
    return a;
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {1, 3, 3, 5, 7}, solution(new int[] {1, 5, 3, 7, 3}, 0, 7));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {-3, -3, -1, 5, 7}, solution(new int[] {-1, 5, -3, 7, -3},
        -3, 7));
  }
}
