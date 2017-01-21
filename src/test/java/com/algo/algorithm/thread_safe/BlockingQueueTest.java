package com.algo.algorithm.thread_safe;

import org.junit.Assert;
import org.junit.Test;

public class BlockingQueueTest {

  @SuppressWarnings("unchecked")
  @Test
  public void test1() throws InterruptedException {
    @SuppressWarnings("rawtypes")
    BlockingQueue bq = new ArrayBlockingQueue(1);
    bq.push("Test");
    Assert.assertEquals(bq.pop(), "Test");
  }

  @SuppressWarnings("unchecked")
  @Test
  public void test2() throws InterruptedException {
    @SuppressWarnings("rawtypes")
    BlockingQueue bq = new ArrayBlockingQueue(1);
    try {
      bq.push(null);
    } catch (Throwable expected) {
      Assert.assertEquals(NullPointerException.class, expected.getClass());
    }
  }

  @SuppressWarnings("unchecked")
  @Test
  public void test3() throws InterruptedException {
    @SuppressWarnings("rawtypes")
    BlockingQueue bq = new ArrayBlockingQueue(2);
    bq.push("1");
    bq.push("2");
    Assert.assertEquals(bq.pop(), "1");
    Assert.assertEquals(bq.pop(), "2");
  }
}