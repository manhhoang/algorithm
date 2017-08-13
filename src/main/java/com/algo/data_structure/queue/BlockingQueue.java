package com.algo.data_structure.queue;

public interface BlockingQueue<E> extends Iterable<E> {

  void push(E e) throws InterruptedException;

  E pop() throws InterruptedException;
}
