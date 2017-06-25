package com.algo.algorithm.string;

/**
 * Check if 2 string anagram.
 *
 * Input:
 * a = "abc"
 * b = "bac"
 *
 * Output:
 * true
 *
 */
public class ValidAnagram {

    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length())
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
            arr[b.charAt(i) - 'a']--;
        }

        for (int i : arr)
            if (i != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "bac";
        System.out.println(isAnagram(a, b));
    }

}
