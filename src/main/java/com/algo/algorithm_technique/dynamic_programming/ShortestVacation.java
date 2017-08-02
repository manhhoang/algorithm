package com.algo.algorithm_technique.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;


/*
 You want to spend your next vacation in a foreign country. In the summer you are free for N consecutive days.
 You have consulted Travel Agency and learned that they are offering a trip to some interesting location in the country every day.
 For simplicity, each location is identified by a number from 0 to N − 1.
 Trips are described in a non-empty zero-indexed array A: for each K (0 ≤ K < N), A[K] is the identifier of a location which is the destination of a trip offered on day K.
 Travel Agency does not have to offer trips to all locations, and can offer more than one trip to some locations.

 You want to go on a trip every day during your vacation.
 Moreover, you want to visit all locations offered by Travel Agency.
 You may visit the same location more than once, but you want to minimize duplicate visits.
 The goal is to find the shortest vacation (a range of consecutive days) that will allow you to visit all the locations offered by Travel Agency.

 For example, consider array A such that:
 A[0] = 7
 A[1] = 3
 A[2] = 7
 A[3] = 3
 A[4] = 1
 A[5] = 3
 A[6] = 4
 A[7] = 1

 Travel Agency offers trips to four different locations (identified by numbers 1, 3, 4 and 7).
 The shortest vacation starting on day 0 that allows you to visit all these locations ends on day 6 (thus is seven days long).
 However, a shorter vacation of five days (starting on day 2 and ending on day 6) also permits you to visit all locations.
 On every vacation shorter than five days, you will have to miss at least one location.
 */
public class ShortestVacation {

    private int solution(int[] A) {

        return 0;
    }

    @Test
    private void test1() {
        int[] A = new int[8];
        A[0] = 7;
        A[1] = 3;
        A[2] = 7;
        A[3] = 3;
        A[4] = 1;
        A[5] = 3;
        A[6] = 4;
        A[7] = 1;
        Assert.assertEquals(5, solution(A));
    }
}
