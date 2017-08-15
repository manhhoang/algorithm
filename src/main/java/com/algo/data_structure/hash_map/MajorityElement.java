package com.algo.data_structure.hash_map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * Input:
 * {1, 1, 2, 2, -3, -3, -3, -3, -3}
 * {1, 1, 2, 2, -3, -3, -3, -3}
 * <p>
 * Output:
 * -3
 * No
 */
public class MajorityElement {

    public static String majorityElement(int[] nums) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.merge(nums[i], 1, Integer::sum);
            if (map.get(nums[i]) * 2 > nums.length) {
                return String.valueOf(nums[i]);
            }
        }

        return "No";
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2, 2, -3, -3, -3, -3, -3};
        System.out.println(majorityElement(num));
    }
}
