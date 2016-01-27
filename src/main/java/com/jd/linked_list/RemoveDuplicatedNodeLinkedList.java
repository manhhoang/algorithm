package com.jd.linked_list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatedNodeLinkedList {

  private static class LinkedList {
    int val;
    LinkedList next;

    LinkedList(int val) {
      this.val = val;
      next = null;
    }
  }

  public static LinkedList removeDuplicates(LinkedList head) {
    for (LinkedList x = head; x != null && x.next != null;) {
      if (x.val == x.next.val) {
        x.next = x.next.next;
      } else {
        x = x.next;
      }
    }
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

  public static Object[] solution(int[] arr) {
    LinkedList list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedList output = removeDuplicates(list);
    List<Integer> ans = new ArrayList<>();
    while (output != null) {
      ans.add(output.val);
      output = output.next;
    }
    return ans.toArray();
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new Object[] {1, 2, 4, 5}, solution(new int[] {1, 2, 2, 4, 5}));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new Object[] {5, 2, 1}, solution(new int[] {5, 2, 1}));
  }

  @Test
  public void test3() {
    Assert.assertArrayEquals(new Object[] {1}, solution(new int[] {1}));
  }

  @Test
  public void test4() {
    Assert.assertArrayEquals(new Object[] {1}, solution(new int[] {1, 1}));
  }

  @Test
  public void test5() {
    Assert.assertArrayEquals(new Object[] {3, 1}, solution(new int[] {3, 3, 1}));
  }

  @Test
  public void test6() {
    Assert.assertArrayEquals(new Object[] {1}, solution(new int[] {1, 1, 1, 1}));
  }

  @Test
  public void test7() {
    Assert.assertArrayEquals(new Object[] {1, 2}, solution(new int[] {1, 1, 2, 2}));
  }
}
