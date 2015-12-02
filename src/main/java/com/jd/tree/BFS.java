package com.jd.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public static void levelOrderQueue(BTNode root) {
    Queue<BTNode> q = new LinkedList<BTNode>();
    if (root == null)
      return;
    q.add(root);
    while (!q.isEmpty()) {
      BTNode n = (BTNode) q.remove();
      System.out.print(" " + n.key);
      if (n.left != null)
        q.add(n.left);
      if (n.right != null)
        q.add(n.right);
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    BTNode root = new BTNode(5);
    root.left = new BTNode(10);
    root.right = new BTNode(15);
    root.left.left = new BTNode(20);
    root.left.right = new BTNode(25);
    root.right.left = new BTNode(30);
    root.right.right = new BTNode(35);

    System.out.println("Breadth First Search : ");
    levelOrderQueue(root);
  }
}
