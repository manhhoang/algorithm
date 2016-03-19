package com.jd.algo.recursive_programming;

import org.junit.Assert;
import org.junit.Test;

public class TotalPositiveInteger {

  public int solution(int n) {
    if (n >= 0) {
      int total = solution(n - 1);
      return n + total;
    } else {
      return 0;
    }
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(2));
  }

  @Test
  public void test2() {
    Assert.assertEquals(6, solution(3));
  }

  @Test
  public void test3() {
    Assert.assertEquals(15, solution(5));
  }

  @Test
  public void test4() {
    Assert.assertEquals(45, solution(9));
  }
}
