package com.jd.sorting;

public class InsertionSort {

    public static void sort(int[] a) {
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < a.length; j++) { // Start with 1 (not 0)
            key = a[j];
            for (i = j - 1; (i >= 0) && (a[i] < key); i--) { // Smaller values are moving up
                a[i + 1] = a[i];
            }
            a[i + 1] = key;    // Put the key in its proper location
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
