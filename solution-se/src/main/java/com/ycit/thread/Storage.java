package com.ycit.thread;

import java.util.LinkedList;

/**
 * 仓库
 *
 * @author xlch
 * @Date 2017-11-24 13:07
 */
public class Storage {

    protected final int MAX_SIZE = 100;
    protected LinkedList<Object> queue = new LinkedList<>();

    public void produce(int num) {
        synchronized (queue) {
            while (queue.size() + num > MAX_SIZE) {
                System.out.println("【库存量】:" + queue.size() + "/t【本次生产量】:" + num +
                        "/t【最大容量】:" + MAX_SIZE + "/t 即将爆仓，暂停生产，等待消费！");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                queue.add(new Object());
            }
            System.out.println("生产完成，【本次生产量】:" + num + "/t【库存量】:" + queue.size());
            queue.notifyAll();
        }
    }

    public void consume(int num) {
      synchronized (queue) {
          while (queue.size() < num) {
              System.out.println("【库存量】:" + queue.size()
                      + "/t【本次需要消费量】:" + num + "/t 【库存量不足，等待生产!】");
              try {
                  queue.wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          for (int i = 0; i < num; i++) {
              queue.remove();
          }
          System.out.println("本次消费完成，【消费产品】:"
                  + num + "/t 【目前库存量】:" + queue.size());
          queue.notifyAll();
      }
    }

}
