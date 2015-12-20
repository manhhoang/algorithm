package com.jd.algorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequence {

  public int[] solution(int[] a) {
    int len = a.length;
    int[] ans = new int[len];
    Arrays.sort(a);
    for (int i = 0; i < len; i++) {

    }
    return ans;
  }

  @Test
  public void test1() {
    int[] a = new int[] {100, 4, 200, 1, 3, 2};
    Assert.assertArrayEquals(new int[] {1, 2, 3, 4}, a);
  }

}
