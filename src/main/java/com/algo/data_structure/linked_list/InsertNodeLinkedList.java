package com.algo.data_structure.linked_list;

public class InsertNodeLinkedList {

  class Node {
    int data;
    Node next;
  }

  Node InsertByWhileLoop(Node head, int data) {
    Node node = new Node();
    node.data = data;
    node.next = null;
    Node x = head;
    while (x != null) {
      if (x.next == null) {
        x.next = node;
        return head;
      }
      x = x.next;
    }
    head = node;
    return head;
  }

  Node InsertByForLoop(Node head, int data) {
    Node node = new Node();
    node.data = data;
    node.next = null;
    for (Node x = head; x != null; x = x.next) {
      if (x.next == null) {
        x.next = node;
        return head;
      }
    }
    head = node;
    return head;
  }

  Node InsertNth(Node head, int data, int position) {
    int i = 0;
    for (Node x = head; x != null; x = x.next) {
      if (i == position - 1 && position > 0) {
        Node node = new Node();
        node.data = data;
        node.next = x.next;
        x.next = node;
      } else if (position == 0) {
        Node node = new Node();
        node.data = data;
        node.next = x;
        return node;
      }
      i++;
    }
    return head;
  }

}
