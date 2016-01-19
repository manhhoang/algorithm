package com.jd.hash_map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindMostRepeatedSubstring {

  public int findOccurences(String s, int k) {
    int max = 1;
    Map<String, Integer> map = new HashMap<String, Integer>();
    int counter = 0;
    String sub;
    int stringLen = s.length();
    for (int i = 0; i < stringLen - k + 1; i++) {
      sub = s.substring(i, i + k);
      if (map.containsKey(sub)) {
        counter = map.get(sub);
        counter++;
        max = Math.max(counter, max);
        map.put(sub, counter);
        counter = 0;
      } else {
        map.put(sub, 1);
      }
    }
    return max;
  }

  public int solution(int K, int L, String s) {
    int ans = 1;
    for (int i = K; i < L; i++) {
      int max = findOccurences(s, i);
      ans = Math.max(max, ans);
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(2, 3, "ababab"));
  }

  @Test
  public void test2() {
    Assert.assertEquals(1, solution(1, 3, "abcde"));
  }

  @Test
  public void test3() {
    Assert.assertEquals(2, solution(1, 3, "abcabc"));
  }

}
