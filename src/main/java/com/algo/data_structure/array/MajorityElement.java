package com.algo.data_structure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 *
 * Input:
 * {1, 1, 2, 2, -3, -3, -3, -3, -3}
 * {1, 1, 2, 2, -3, -3, -3, -3}
 *
 * Output:
 * -3
 * No
 *
 */
public class MajorityElement {

    // Sorting O(nlogn)
    public static int majorityElement1(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        Arrays.sort(num);
        return num[num.length / 2];
    }

    // Hashtable O(n)
    public static String majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
           int count = map.getOrDefault(nums[i], 0);
           count++;
           map.put(nums[i], count);
           if(count * 2 > nums.length) {
               return String.valueOf(nums[i]);
           }
        }
        return "No";
    }

    // Moore voting algorithm O(n)
    public static int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                ret = nums[i];
            if (nums[i] != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // Bit manipulation
    public static int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31-i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length/2 ? 1 : 0;
            ret += bit[i] * (1 << (31-i));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, -3, 2, -3, -3, -3, 1};
        System.out.println(majorityElement1(num));
        System.out.println(majorityElement2(num));
        System.out.println(majorityElement3(num));
        System.out.println(majorityElement4(num));
    }
}
