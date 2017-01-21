package com.algo.algorithm.combinatorial_enumeration;

import java.util.ArrayList;
import java.util.List;


public class CombinationsMultipleList {

    private static class Node {
        public String value;

        public Node(String value) {
            this.value = value;
        }
    }

    private static void printSolve(int d, String s, List<ArrayList<Node>> list) {
        if (d == list.size()) {
            System.out.println(s.substring(0, s.length() - 1));
            return;
        }
        for (int i = 0; i < list.get(d).size(); i++) {
            printSolve(d + 1, s + list.get(d).get(i).value + " ", list);
        }
        return;
    }

    private static int countSolve(int d, String s, List<ArrayList<Node>> list) {
        int count = 0;
        if (d == list.size()) {
            return 1;
        }
        for (int i = 0; i < list.get(d).size(); i++) {
            int c = countSolve(d + 1, s + list.get(d).get(i).value + " ", list);
            count += c;
        }
        return count;
    }

    public static void main(String[] args) {
        List<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node("A1"));
        nodes.add(new Node("A2"));
        list.add(nodes);

        nodes = new ArrayList<Node>();
        nodes.add(new Node("B1"));
        nodes.add(new Node("B2"));
        list.add(nodes);

        printSolve(0, "", list);
        System.out.println("Total combination: " + countSolve(0, "", list));
    }

}
