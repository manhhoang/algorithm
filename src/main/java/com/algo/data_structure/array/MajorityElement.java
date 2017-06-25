package com.algo.data_structure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
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

    public static int majorityElement1(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        Arrays.sort(num);
        return num[num.length / 2];
    }

    public static int majorityElement2(int[] nums) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(count == 0){
                result = nums[ i ];
                count = 1;
            }else if(result == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return result;
    }

    public static String majorityElement3(int[] nums) {
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

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2, 2, -3, -3, -3, -3, -3};
        System.out.println(majorityElement1(num));
        System.out.println(majorityElement2(num));
        System.out.println(majorityElement3(num));
    }
}
