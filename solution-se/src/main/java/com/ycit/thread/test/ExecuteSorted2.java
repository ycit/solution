package com.ycit.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序执行
 *  T1 T2 T3 线程 分别 输出 1 2 3 ，输出 10个 1 2 3
 *  形如  123123123...
 * @author xlch
 * @Date 2017-12-08 18:13
 */
public class ExecuteSorted2 {


    static int running = 1;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition t1c = lock.newCondition();
        Condition t2c = lock.newCondition();
        Condition t3c = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (running != 1) {
                    t2c.signalAll();
                    try {
                        t1c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1");
                running = 2;
                if (i == 9) {
                    t2c.signalAll();
                }

            }
            lock.unlock();
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (running != 2) {
                    t3c.signalAll();
                    try {
                        t2c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("2");
                running = 3;
                if (i == 9) {
                    t3c.signalAll();
                }
            }
            lock.unlock();
        });
        Thread t3 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (running != 3) {
                    t1c.signalAll();
                    try {
                        t3c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("3");
                running = 1;
                if (i == 9) {
                    t1c.signalAll();
                }
            }
            lock.unlock();
        });
        t1.start();
        t2.start();
        t3.start();

    }

}
