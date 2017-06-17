package com.algo.algorithm_technique.two_pointers;

import java.util.Arrays;

public class CountDuplicatedElement {

    private static int solution(int[] a) {
        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i < a.length;) {
            int j = i;
            int count = 1;
            while (j < a.length) {
                if (a[j] == a[i]) {
                    count++;
                    j++;
                } else {
                    max = Math.max(max, count);
                    break;
                }
            }
            if (i != j)
                i = j;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 2, 4, 3, 2};
        int ans = solution(a);
        System.out.println(ans);
    }
}
