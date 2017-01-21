package com.algo.data_structure.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatedNodeLinkedList {

  private static class LinkedList {
    int val;
    LinkedList next;
    int len;

    LinkedList(int val) {
      this.val = val;
      next = null;
    }
  }

  public static LinkedList removeDuplicates(LinkedList head) {
    int len = 1;
    for (LinkedList x = head; x != null && x.next != null;) {
      if (x.val == x.next.val) {
        x.next = x.next.next;
      } else {
        x = x.next;
        len++;
      }
    }
    head.len = len;
    return head;
  }

  public static LinkedList insert(LinkedList head, int val) {
    if (head == null) {
      head = new LinkedList(val);
    } else {
      LinkedList current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new LinkedList(val);
    }
    return head;
  }

  public static int[] solution(int[] arr) {
    LinkedList list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedList output = removeDuplicates(list);
    int[] ans = new int[output.len];
    int i = 0;
    while (output != null) {
      ans[i] = output.val;
      output = output.next;
      i++;
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {1, 2, 4, 5}, solution(new int[] {1, 2, 2, 4, 5}));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {5, 2, 1}, solution(new int[] {5, 2, 1}));
  }

  @Test
  public void test3() {
    Assert.assertArrayEquals(new int[] {1}, solution(new int[] {1}));
  }

  @Test
  public void test4() {
    Assert.assertArrayEquals(new int[] {1}, solution(new int[] {1, 1}));
  }

  @Test
  public void test5() {
    Assert.assertArrayEquals(new int[] {3, 1}, solution(new int[] {3, 3, 1}));
  }

  @Test
  public void test6() {
    Assert.assertArrayEquals(new int[] {1}, solution(new int[] {1, 1, 1, 1}));
  }

  @Test
  public void test7() {
    Assert.assertArrayEquals(new int[] {1, 2}, solution(new int[] {1, 1, 2, 2}));
  }
}
