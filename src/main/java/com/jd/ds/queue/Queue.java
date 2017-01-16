package com.jd.ds.queue;

public class Queue<T> {
    private class Node {
        private T val;
        private Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public void enqueue(T val){
        Node node = new Node();
        node.val = val;
        node.next = null;
        if(last != null){
            last.next = node;
            last = node;
        } else{
            last = node;
            first = last;
        }
        N++;
    }

    public T dequeue(){
        if(first == null)
            first = last;
        T temp = first.val;
        first = first.next;
        N--;
        return temp;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println(q.N);
        System.out.println(q.N + " : " + q.dequeue());
        System.out.println(q.N + " : " + q.dequeue());
        System.out.println(q.N + " : " + q.dequeue());
    }
}
