package com.ycit.thread;

/**
 * 多线程
 *
 * @author xlch
 * @Date 2017-11-24 10:58
 */
public class SimpleThread extends Thread {

    private int countDown = 5;
    private int threadNum = 0;
    private static int threadCount = 0;

    public SimpleThread() {
        threadNum = ++threadCount;
        System.out.println("making " + threadNum);
    }

    public void run() {
        while (true) {
            System.out.println("thread " + threadNum + "(count is " + countDown + ")");
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread().start();
        }
        System.out.println("all thread is completed");
    }

    class T1 implements Runnable {
        @Override
        public void run() {

        }
    }
}
