package com.jd.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> returnList = new ArrayList<>();

    if(root == null)
      return returnList;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while(!stack.empty()){
      TreeNode n = stack.pop();
      returnList.add(n.val);

      if(n.right != null){
        stack.push(n.right);
      }
      if(n.left != null){
        stack.push(n.left);
      }

    }
    return returnList;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(10);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(25);
    root.right.left = new TreeNode(30);
    root.right.right = new TreeNode(35);

    System.out.println("Breadth First Search : ");
    List<Integer> result = preorderTraversal(root);
    System.out.println(result.toString());
  }

}
