package com.jd.ds.stack;

public class Stack<T> {
    private class Node{
        private T val;
        private Node next;
    }

    private int N;
    private Node first;

    public void push(T val){
        Node node = new Node();
        node.val = val;
        node.next = first;
        first = node;
        N++;
    }

    public T pop(){
        T temp = first.val;
        first = first.next;
        N--;
        return temp;
    }

    public static void main(String[] args) {
        Stack<String> q = new Stack<>();
        q.push("A");
        q.push("B");
        q.push("C");
        System.out.println(q.N);
        System.out.println(q.N + " : " + q.pop());
        System.out.println(q.N + " : " + q.pop());
        System.out.println(q.N + " : " + q.pop());
    }

}
