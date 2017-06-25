package com.algo.algorithm_technique.divide_and_conquer;

/**
 * Sort array after converting elements to their squares
 *
 * Input:
 * arr[] =  {-6, -3, -1, 2, 4, 5}
 *
 * Output:
 * 1, 4, 9, 16, 25, 36
 *
 * O(n)
 */
public class SortSquare {

    public static void sortSquares(int arr[]) {
        int n = arr.length;
        // first divide array into part negative and positive
        int k;
        for(k = 0; k < n; k++) {
            if(arr[k] >= 0)
                break;
        }

        int i = k-1; // Initial index of first half
        int j = k; // Initial index of second half
        int m = 0; // Initial index of merged array

        int[] merged = new int[n];
        while(i >= 0 && j < n) {
            if(arr[i] * arr[i] < arr[j] * arr[j]) {
                merged[m] = arr[i] * arr[i];
                i--;
            }
            else {
                merged[m] = arr[j] * arr[j];
                j++;
            }
            m++;
        }

        while(i >= 0) {
            merged[m++] = arr[i] * arr[i];
            i--;
        }
        while(j < n) {
            merged[m++] = arr[j] * arr[j];
            j++;
        }

        // copy 'merged' array into original array
        for (int x = 0 ; x < n; x++)
            arr[x] = merged[x];
    }

    public static void main (String[] args) {
        int arr[] = {-6 , -3 , -1 , 2 , 4 , 5};
        int n = arr.length;
        sortSquares(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
