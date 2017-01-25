package com.algo.data_structure.tree.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> returnList = new ArrayList<>();

        if (root == null)
            return returnList;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node n = stack.pop();
            returnList.add(n.val);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        System.out.println("Depth First Search : ");
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result.toString());
    }

}
