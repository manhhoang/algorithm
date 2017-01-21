package com.algo.algorithm.string;

import com.algo.algorithm.util.StdIn;
import com.algo.algorithm.util.StdOut;
import com.algo.data_structure.trie.SuffixArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

    /**
     * The <tt>LongestRepeatedSubstring</tt> class provides a {@link SuffixArray} client for computing
     * the longest repeated substring of a string that appears at least twice. The repeated substrings
     * may overlap (but must be distinct).
     * <p>
     * For additional documentation, see <a href="http://algs4.cs.princeton.edu/63suffix">Section
     * 6.3</a> of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
     * <p>
     * See also {@link LongestCommonSubstring}.
     *
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    public static class LongestRepeatedSubstring {

      // Do not instantiate.
      private LongestRepeatedSubstring() {
      }

      /**
       * Returns the longest common string of the two specified strings.
       *
       * @param s one string
       * @param t the other string
       * @return the longest common string that appears as a substring
       */

      /**
       * Returns the longest repeated substring of the specified string.
       *
       * @param text the string
       * @return the longest repeated substring that appears in <tt>text</tt>; the empty string if no
       *         such string
       */
      public static String lrs(String text) {
        int N = text.length();
        SuffixArray sa = new SuffixArray(text);
        String lrs = "";
        for (int i = 1; i < N; i++) {
          int length = sa.lcp(i);
          if (length > lrs.length()) {
            // lrs = sa.select(i).substring(0, length);
            lrs = text.substring(sa.index(i), sa.index(i) + length);
          }
        }
        return lrs;
      }

      /**
       * Unit tests the <tt>lrs()</tt> method.
       *
       * @throws IOException
       */
      public static void main(String[] args) throws IOException {
        String path = new File(".").getCanonicalPath();
        String fileName = path + "/src/cs/tinyTale.txt"; // mobydick.txt
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        StdIn.scanner = sc;
        String text = StdIn.readAll().replaceAll("\\s+", " ");
        StdOut.println("'" + lrs(text) + "'");
      }
    }
}
