package com.algo.data_structure.tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class Node {
        int key;
        String name;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }
    }

    public static void levelOrderQueue(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(" " + n.key);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        System.out.println("Breadth First Search : ");
        levelOrderQueue(root);
    }
}
