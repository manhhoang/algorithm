package com.algo.data_structure.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Check parenthesis well balancing.
 *
 * Input:
 * {([])}
 * {([)}
 *
 * Output:
 * true
 * false
 *
 */
public class Parenthesis {

    public static boolean solve(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        String[] str = new String[] {"(", "{", "[", "]", "}", ")"};
        int len = s.length();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            String k = String.valueOf(s.charAt(i));
            if(k.trim().equals("") || !Arrays.asList(str).contains(k)) {
                continue;
            }
            if (map.keySet().contains(k)) {
                st.push(k);
            } else if (st.size() > 0) {
                String p = st.pop();
                if (!map.get(p).equals(k)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (st.size() > 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test1() {
        String s = "([{})]";
        Assert.assertFalse(solve(s));
    }

    @Test
    public void test2() {
        String s = "([{}])";
        Assert.assertTrue(solve(s));
    }

    @Test
    public void test3() {
        String s = "({}])";
        Assert.assertFalse(solve(s));
    }

    @Test
    public void test4() {
        String s = "({{}])";
        Assert.assertFalse(solve(s));
    }

    @Test
    public void test5() {
        String s = "()";
        Assert.assertTrue(solve(s));
    }

    @Test
    public void test6() {
        String s = "())";
        Assert.assertFalse(solve(s));
    }

    @Test
    public void test7() {
        String s = "(())";
        Assert.assertTrue(solve(s));
    }

    @Test
    public void test8() {
        Assert.assertFalse(solve("([]"));
    }

    @Test
    public void test9() {
        Assert.assertTrue(solve("(((185 + 223.85) * 15) - 543)/2"));
    }

    @Test
    public void test10() {
        String s = "( )";
        Assert.assertTrue(solve(s));
    }
}
