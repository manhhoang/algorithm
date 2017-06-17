package com.algo.data_structure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NestedArray {

    public int solution(int[] A) {
        boolean[] B = new boolean[A.length];
        Arrays.fill(B, false);
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            int j = A[i];
            B[i] = true;
            int count = 1;
            while(!B[j]){
                B[j] = true;
                j = A[j];
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, solution(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution(new int[]{1, 0, 3, 4, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, solution(new int[]{0}));
    }
}
