package com.algo.data_structure.tree.binary_tree;

import java.util.Stack;

public class BinaryTreePreOrderIterator {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    Stack<Node> stack = new Stack<>();

    public BinaryTreePreOrderIterator(Node root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node node = stack.pop();
        int value = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return value;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported.");
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        BinaryTreePreOrderIterator ite = new BinaryTreePreOrderIterator(root);
        while (ite.hasNext()) {
            int value = ite.next();
            System.out.println(value);
        }
    }

}
