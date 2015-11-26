package com.jd.tree;

import java.io.File;
import java.util.Scanner;

class TreeNode {
  int key;
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int k) {
    key = k;
  }

}

public class WBT_Weight_Balanced_Tree {

  private static void addNode(TreeNode node, int key, int weightLeft, int childKeyLeft,
      int weightRight, int childKeyRight) {
    if (childKeyLeft != -1) {
      TreeNode childLeft = new TreeNode(childKeyLeft);
      node.left = childLeft;
    }

    if (childKeyRight != -1) {
      TreeNode childRight = new TreeNode(childKeyRight);
      node.right = childRight;
    }
  }

  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/cs/WBT_Weight_Balanced_Tree";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    int N = sc.nextInt();
    sc.nextLine();
    TreeNode root = new TreeNode(0);
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
