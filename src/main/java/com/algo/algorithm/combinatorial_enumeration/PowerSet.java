package com.algo.algorithm.combinatorial_enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PowerSet {

    public static ArrayList<String> getPowerset(int a[], int n, ArrayList<String> ps) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            if (ps == null)
                ps = new ArrayList<String>();
            ps.add(" ");
            return ps;
        }
        ps = getPowerset(a, n - 1, ps);
        ArrayList<String> tmp = new ArrayList<String>();
        for (String s : ps) {
            if (s.equals(" "))
                tmp.add("" + a[n - 1]);
            else
                tmp.add(s + a[n - 1]);
        }
        ps.addAll(tmp);
        return ps;
    }

    public static <T> List<List<T>> powerset(Collection<T> list) {
        List<List<T>> ps = new ArrayList<List<T>>();
        ps.add(new ArrayList<T>()); // add the empty set

        // for every item in the original list
        for (T item : list) {
            List<List<T>> newPs = new ArrayList<List<T>>();

            for (List<T> subset : ps) {
                // copy all of the current powerset's subsets
                newPs.add(subset);

                // plus the subsets appended with the current item
                List<T> newSubset = new ArrayList<T>(subset);
                newSubset.add(item);
                newPs.add(newSubset);
            }

            // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
            ps = newPs;
        }
        return ps;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        ArrayList<String> ps = new ArrayList<>();
        getPowerset(a, a.length, ps);
        ps.forEach((x) -> System.out.println(x));

        System.out.println();

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<List<String>> ans = powerset(list);
        ans.forEach((x) -> System.out.println(x));
    }
}
