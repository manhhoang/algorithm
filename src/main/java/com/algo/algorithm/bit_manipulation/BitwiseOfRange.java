package com.algo.algorithm.bit_manipulation;

import org.junit.Assert;
import org.junit.Test;

public class BitwiseOfRange {

    public static int solution(int m, int n){
        while(n > m){
            n = n & n - 1;
        }
        return m & n;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, solution(5, 7));
    }

}
