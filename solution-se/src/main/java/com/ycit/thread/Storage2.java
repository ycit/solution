package com.ycit.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await,signal 实现生产者消费者
 *
 * @author xlch
 * @Date 2017-11-24 14:16
 */
public class Storage2 extends Storage {

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();

    private final Condition empty = lock.newCondition();

    @Override
    public void produce(int num) {
        lock.lock();
        while (queue.size() + num > MAX_SIZE) {
            System.out.println("【库存量】:" + queue.size() + "/t【本次生产量】:" + num +
                    "/t【最大容量】:" + MAX_SIZE + "/t 即将爆仓，暂停生产，等待消费！");
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < num; i++) {
            queue.add(new Object());
        }
        System.out.println("生产完成，【本次生产量】:" + num + "/t【库存量】:" + queue.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    @Override
    public void consume(int num) {
        lock.lock();
        while (queue.size() < num) {
            System.out.println("【库存量】:" + queue.size()
                    + "/t【本次需要消费量】:" + num + "/t 【库存量不足，等待生产!】");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < num; i++) {
            queue.remove();
        }
        System.out.println("本次消费完成，【消费产品】:"
                + num + "/t 【目前库存量】:" + queue.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }
}
