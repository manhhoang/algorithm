package com.algo.data_structure.queue;

import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<E> implements BlockingQueue<E> {
  private final E[] eles;
  private int popIndex;
  private int pushIndex;
  private int count;
  private final ReentrantLock lock;
  private final Condition empty;
  private final Condition full;

  public ArrayBlockingQueue(int cap) {
    if (cap <= 0)
      throw new IllegalArgumentException();
    this.eles = (E[]) new Object[cap];
    lock = new ReentrantLock(false);
    empty = lock.newCondition();
    full = lock.newCondition();
  }

  public Iterator<E> iterator() {
    return null;
  }

  public void push(E e) throws InterruptedException {
    if (e == null)
      throw new NullPointerException();
    final E[] eles = this.eles;
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
      try {
        while (count == eles.length)
          full.await();
      } catch (InterruptedException ie) {
        full.signal();
        throw ie;
      }
      eles[pushIndex] = e;
      pushIndex = ++pushIndex == eles.length ? 0 : pushIndex;
      ++count;
      empty.signal();
    } finally {
      lock.unlock();
    }
  }

  public E pop() throws InterruptedException {
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
      try {
        while (count == 0)
          empty.await();
      } catch (InterruptedException ie) {
        empty.signal();
        throw ie;
      }
      final E[] eles = this.eles;
      E x = eles[popIndex];
      eles[popIndex] = null;
      popIndex = ++popIndex == eles.length ? 0 : popIndex;
      --count;
      full.signal();
      return x;
    } finally {
      lock.unlock();
    }
  }

  @SuppressWarnings({"rawtypes"})
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue bq = new ArrayBlockingQueue(2);

    Producer producer = new Producer(bq);
    Consumer consumer = new Consumer(bq);
    new Thread(producer).start();
    new Thread(consumer).start();

    Thread.sleep(4000);
  }
}

class Producer implements Runnable {
  @SuppressWarnings("rawtypes")
  private BlockingQueue bq = null;

  @SuppressWarnings("rawtypes")
  public Producer(BlockingQueue queue) {
    this.setBlockingQueue(queue);
  }

  @SuppressWarnings("unchecked")
  public void run() {
    try {
      System.out.println("Push: 1");
      bq.push("1");
      Thread.sleep(1000);
      System.out.println("Push: 2");
      bq.push("2");
      Thread.sleep(1000);
      System.out.println("Push: 3");
      bq.push("3");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("rawtypes")
  public void setBlockingQueue(BlockingQueue bq) {
    this.bq = bq;
  }
}

class Consumer implements Runnable {

  @SuppressWarnings("rawtypes")
  protected BlockingQueue queue = null;

  @SuppressWarnings("rawtypes")
  public Consumer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void run() {
    try {
      System.out.println("Pop: " + queue.pop());
      // System.out.println("Pop: " + queue.pop());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
