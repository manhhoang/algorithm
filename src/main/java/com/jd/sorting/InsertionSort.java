package com.jd.sorting;

public class InsertionSort {

    public static void sort(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String arr[]) {
        int[] a = {10, 34, 2, 56, 7, 67, 88, 42};
        sort(a);
        for (int i : a) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

}
