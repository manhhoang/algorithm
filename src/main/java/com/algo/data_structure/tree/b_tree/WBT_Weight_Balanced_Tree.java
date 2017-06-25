package com.algo.data_structure.tree.b_tree;

import java.io.File;
import java.util.Scanner;

public class WBT_Weight_Balanced_Tree {

    static class Node {
        int key;
        int val;
        Node left;
        Node right;

        Node(int k) {
            key = k;
        }

    }

    private static void addNode(Node node, int key, int weightLeft, int childKeyLeft,
                                int weightRight, int childKeyRight) {
        if (childKeyLeft != -1) {
            Node childLeft = new Node(childKeyLeft);
            node.left = childLeft;
        }

        if (childKeyRight != -1) {
            Node childRight = new Node(childKeyRight);
            node.right = childRight;
        }
    }

    public static void main(String[] args) throws Exception {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/data/WBT_Weight_Balanced_Tree";
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        int N = sc.nextInt();
        sc.nextLine();
        Node root = new Node(0);
        for (int i = 0; i < N; i++) {
            String[] lineLeft = sc.nextLine().split(" ");
            String[] lineRight = sc.nextLine().split(" ");
            int key = i;
            int weightLeft = sc.nextInt();
            int childKeyLeft = lineLeft.length == 2 ? sc.nextInt() : -1;
            int weightRight = sc.nextInt();
            int childKeyRight = lineRight.length == 2 ? sc.nextInt() : -1;
            addNode(root, key, weightLeft, childKeyLeft, weightRight, childKeyRight);
        }

    }

}
