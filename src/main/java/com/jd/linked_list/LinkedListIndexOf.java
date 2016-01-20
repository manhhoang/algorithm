package com.jd.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListIndexOf {

  private static class LinkedList {
    int val;
    LinkedList next;

    LinkedList(int val) {
      this.val = val;
      next = null;
    }
  }

  private static int count(LinkedList head) {
    int count = 1;
    while (head.next != null) {
      head = head.next;
      count++;
    }
    return count;
  }

  static int indexOf(LinkedList source, LinkedList target) {
    LinkedList first = target;
    int sourceCount = count(source);
    int targetCount = count(target);
    int max = (sourceCount - targetCount);

    for (int i = 0; i <= max; i++) {
      /* Look for first item. */
      if (source.val != first.val) {
        while (source.next != null && source.val != first.val) {
          source = source.next;
          i++;
        }
      }

      /* Found first item, now look at the rest of list */
      if (i <= max) {
        int j = i + 1;
        int end = j + targetCount - 1;
        while (source.next != null && target.next != null && j < end
            && source.next.val == target.next.val) {
          j++;
          source = source.next;
          target = target.next;
        }
        source = source.next;
        if (j == end) {
          /* Found whole array. */
          return i;
        }
      }
    }
    return -1;
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

  public static int solution(int[] arr, int[] subarr) {
    LinkedList list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedList sublist = null;
    for (int i = 0; i < subarr.length; i++) {
      sublist = insert(sublist, subarr[i]);
    }
    return indexOf(list, sublist);
  }

  @Test
  public void test1() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 5, 4}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(3, solution(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(0, solution(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2}));
  }

  @Test
  public void test6() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4}));
  }

  @Test
  public void test7() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5}));
  }

  @Test
  public void test8() {
    Assert.assertEquals(2, solution(new int[] {2, 3, 2, 4, 5}, new int[] {2, 4}));
  }
}
