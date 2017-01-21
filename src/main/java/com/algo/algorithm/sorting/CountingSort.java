package com.algo.algorithm.sorting;

public class CountingSort {

    public static int[] sort(int[] a, int min, int max) {
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

    public static void main(String arr[]) {
        int[] a = {10, 34, 2, 56, 7, 67, 88, 42};
        sort(a, 0, 100);
        for (int i : a) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
}
