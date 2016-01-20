package com.jd.string_array;

import org.junit.Assert;
import org.junit.Test;

public class CheckPalindrome {

  public boolean solution(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l <= r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      } else {
        l++;
        r--;
      }
    }
    return true;
  }

  @Test
  public void test1() {
    Assert.assertTrue(solution("abba"));
  }

  @Test
  public void test2() {
    Assert.assertFalse(solution("aab"));
  }

  @Test
  public void test3() {
    Assert.assertTrue(solution("a"));
  }

  @Test
  public void test4() {
    Assert.assertFalse(solution("abbaa"));
  }
}
