package com.jd.linked_list;

public class InsertNodeLinkedList {

	class Node {
		int data;
		Node next;
	}

	Node Insert1(Node head, int data) {
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

	Node Insert2(Node head, int data) {
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

}
