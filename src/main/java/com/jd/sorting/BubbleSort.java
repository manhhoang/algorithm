package com.jd.sorting;

public class BubbleSort {

    public static void sort(int[] a) {
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        int temp;   //holding variable

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) { // change to > for ascending sort
                    temp = a[j];                //swap elements
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;              //shows a swap occurred
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
