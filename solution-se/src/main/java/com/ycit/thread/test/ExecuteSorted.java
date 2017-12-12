package com.ycit.thread.test;

/**
 * 按顺序执行线程
 *
 * @author xlch
 * @Date 2017-12-08 17:59
 */
public class ExecuteSorted {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("1"));
        Thread t2 = new Thread(() -> {
            System.out.println("2");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("3");
        });
        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
        t1.join();

    }

}
