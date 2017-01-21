package com.algo.data_structure.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListIndexOf {

  private static class LinkedListNode {
    String val;
    LinkedListNode next;

    LinkedListNode(String node_value) {
      val = node_value;
      next = null;
    }
  }

  private static int count(LinkedListNode head) {
    int count = 1;
    while (head.next != null) {
      head = head.next;
      count++;
    }
    return count;
  }

  static int find(LinkedListNode list, LinkedListNode sublist) {
    LinkedListNode first = sublist;
    int sourceCount = count(list);
    int targetCount = count(sublist);
    int max = (sourceCount - targetCount);

    for (int i = 0; i <= max; i++) {
      while (list.next != null && !list.val.equals(first.val)) {
        list = list.next;
        i++;
      }

      if (i <= max) {
        int j = i + 1;
        int end = j + targetCount - 1;
        while (list.next != null && sublist.next != null && j < end
            && list.next.val.equals(sublist.next.val)) {
          j++;
          list = list.next;
          sublist = sublist.next;
        }
        list = list.next;
        if (j == end) {
          return i;
        }
      }
    }
    return -1;
  }

  public static LinkedListNode insert(LinkedListNode head, String val) {
    if (head == null) {
      head = new LinkedListNode(val);
    } else {
      LinkedListNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new LinkedListNode(val);
    }
    return head;
  }

  public static int solution(String[] arr, String[] subarr) {
    LinkedListNode list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedListNode sublist = null;
    for (int i = 0; i < subarr.length; i++) {
      sublist = insert(sublist, subarr[i]);
    }
    return find(list, sublist);
  }

  @Test
  public void test1() {
    Assert.assertEquals(1, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {
        "2", "3", "4"}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(-1, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {
        "2", "5", "4"}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(3,
        solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"4", "5"}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(0,
        solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"1", "2"}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(1, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {"2"}));
  }

  @Test
  public void test6() {
    Assert.assertEquals(-1, solution(new String[] {"1", "2", "3"},
        new String[] {"1", "2", "3", "4"}));
  }

  @Test
  public void test7() {
    Assert.assertEquals(-1, solution(new String[] {"1", "2", "3"}, new String[] {
        "1", "2", "3", "4", "5"}));
  }

  @Test
  public void test8() {
    Assert.assertEquals(2,
        solution(new String[] {"2", "3", "2", "4", "5"}, new String[] {"2", "4"}));
  }

  @Test
  public void test9() {
    Assert.assertEquals(2, solution(new String[] {"1", "2", "3", "4", "5"}, new String[] {
        "3", "4", "5"}));
  }
}
