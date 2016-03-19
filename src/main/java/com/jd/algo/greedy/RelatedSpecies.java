package com.jd.algo.greedy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RelatedSpecies {

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/cs/Related Species";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      int min = Math.min(a[0], b[0]);
      boolean isNo = false;
      for (int i = 1; i < n; i++) {
        if (a[i] >= min && b[i] >= min) {
          min = Math.min(a[i], b[i]);
        } else if (a[i] >= min && b[i] < min) {
          min = a[i];
        } else if (a[i] < min && b[i] >= min) {
          min = b[i];
        } else {
          System.out.println("NO");
          isNo = true;
          break;
        }
      }
      if (!isNo)
        System.out.println("YES");
    }
  }
}
