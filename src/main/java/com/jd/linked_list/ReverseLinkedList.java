package com.jd.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedList {

  private static class LinkedList {
    int val;
    LinkedList next;

    LinkedList(int val) {
      this.val = val;
      next = null;
    }
  }

  public static LinkedList reverse(LinkedList node) {
    LinkedList prev = null;
    LinkedList current = node;
    LinkedList next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  public static LinkedList insert(LinkedList head, int val) {
    if (head == null) {
      head = new LinkedList(val);
    } else {
      LinkedList end = head;
      while (end.next != null) {
        end = end.next;
      }
      LinkedList node = new LinkedList(val);
      end.next = node;
    }
    return head;
  }

  public static int[] solution(int[] arr) {
    LinkedList list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedList output = reverse(list);
    int[] ans = new int[arr.length];
    int i = 0;
    while (output != null) {
      ans[i++] = output.val;
      output = output.next;
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {5, 4, 3, 2, 1}, solution(new int[] {1, 2, 3, 4, 5}));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {1, 2, 5}, solution(new int[] {5, 2, 1}));
  }

  @Test
  public void test3() {
    Assert.assertArrayEquals(new int[] {1}, solution(new int[] {1}));
  }

  @Test
  public void test4() {
    Assert.assertArrayEquals(new int[] {1, 2}, solution(new int[] {2, 1}));
  }

  @Test
  public void test5() {
    Assert.assertArrayEquals(new int[] {3, 2, 1}, solution(new int[] {1, 2, 3}));
  }

}
