package com.algo.algorithm.math;

import org.junit.Assert;
import org.junit.Test;

public class ReverseInteger {

  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      rev = rev * 10 + x % 10;
      x = x / 10;
    }

    return rev;
  }

  @Test
  public void test1() {
    Assert.assertEquals(321, reverse(123));
  }

  @Test
  public void test2() {
    Assert.assertEquals(-321, reverse(-123));
  }
}
