package com.algo.data_structure.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedLinkedList {

  private static class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
      next = null;
    }
  }

  public static Node mergeLists(Node nodeA, Node nodeB) {
    if (nodeA == null && nodeB == null) {
      return null;
    } else if (nodeA == null) {
      return nodeB;
    } else if (nodeB == null) {
      return nodeA;
    }

    Node nodeC = null;
    if (nodeA != null && nodeB != null) {
      if (nodeA.val <= nodeB.val) {
        nodeC = nodeA;
        nodeC.next = mergeLists(nodeA.next, nodeB);
      } else if (nodeA.val > nodeB.val) {
        nodeC = nodeB;
        nodeC.next = mergeLists(nodeA, nodeB.next);
      }
    }
    return nodeC;
  }

  public static Node insert(Node head, int val) {
    if (head == null) {
      head = new Node(val);
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(val);
    }
    return head;
  }

  public static int[] solution(int[] arr1, int[] arr2) {
    Node listA = null;
    for (int i = 0; i < arr1.length; i++) {
      listA = insert(listA, arr1[i]);
    }

    Node listB = null;
    for (int i = 0; i < arr2.length; i++) {
      listB = insert(listB, arr2[i]);
    }

    Node output = mergeLists(listA, listB);
    int[] ans = new int[5];
    int i = 0;
    while (output != null) {
      ans[i++] = output.val;
      output = output.next;
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {1, 2, 0, 0, 0}, solution(new int[] {1}, new int[] {2}));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 0},
        solution(new int[] {1, 3}, new int[] {2, 4}));
  }

  @Test
  public void test3() {
    Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, solution(new int[] {1, 2}, new int[] {
        3, 4, 5}));
  }

}
