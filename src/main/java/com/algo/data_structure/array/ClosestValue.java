package com.algo.data_structure.array;

/**
 * Find the closest value in an array.
 *
 * Input:
 * a = {36.32, 4.5, 2.5, 7.9, -6.5, 13.6}
 * x = 5.6
 *
 * Output:
 * 4.5
 *
 */
public class ClosestValue {

    private static double findClosest(double[] a, double x) {
        double smallestDiff = Math.abs(x - a[0]);
        int closest = 0; //index of the current closest number

        for (int i = 1; i < a.length; i++) {
            double currentDiff = Math.abs(x - a[i]);
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                closest = i;
            }
        }

        return a[closest];
    }

    public static void main(String[] args) {
        double[] a = new double[]{36.32, 4.5, 2.5, 7.9, -6.5, 13.6};
        System.out.println(findClosest(a, 5.6));
    }
}
