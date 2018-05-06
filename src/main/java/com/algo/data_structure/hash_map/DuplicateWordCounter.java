package com.algo.data_structure.hash_map;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWordCounter {

    public static long count(String input) {
        int ans = 0;
        String[] words = input.split(" ");
        Map<String, Integer> mapCount = new HashMap<>();
        for(String word: words) {
            if(!word.trim().equals("")) {
                String wordLowerCase = word.trim().toLowerCase();
                mapCount.putIfAbsent(wordLowerCase, 0);
                mapCount.merge(wordLowerCase, 1, Integer::sum);
            }
        }
        for(Map.Entry<String, Integer> entry: mapCount.entrySet()) {
            int count = entry.getValue();
            if(count > 1) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        assertEquals(0, DuplicateWordCounter.count("one two"));
    }

    @Test
    public void test1() {
        assertEquals(1, DuplicateWordCounter.count("one   two three TWO four"));
    }
}
