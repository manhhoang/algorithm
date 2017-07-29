package com.algo.algorithm_technique.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = in.nextInt();

        // O(n^2) solution
        // consider the longest sub sequence ending with element at i
        // it is just logest sub sequence ending in j < i + 1 AND a[j] < a[i]

        // O(n log n) solution
        // sEnd[pos] smallest integer that ends with an increasing sequence of length (pos + 1)
        int[] sEnd = new int[N];
        sEnd[0] = a[0];
        int sInd = 0;
        for (int i = 1; i < N; i++) {

            if (a[i] > sEnd[sInd]) {
                sEnd[++sInd] = a[i];
            } else {
                int binInd = Arrays.binarySearch(sEnd, 0, sInd + 1, a[i]);
                if (binInd < 0) {
                    binInd = (binInd + 1) * -1;
                    sEnd[binInd] = a[i];
                }
            }
        }
        System.out.println(sInd + 1);
        in.close();
    }
}
