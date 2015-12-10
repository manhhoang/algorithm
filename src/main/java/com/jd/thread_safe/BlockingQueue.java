package com.jd.thread_safe;

public interface BlockingQueue<E> extends Iterable<E> {

  void push(E e) throws InterruptedException;

  E pop() throws InterruptedException;
}
