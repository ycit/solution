package com.ycit.thread;

/**
 * Created by xlch on 2017/1/9.
 */
public class ThreadWay extends Thread {

    private String name;

    public ThreadWay(String name) {
        this.name = name;
    }

    int count = 15;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " thread run ,count==" + count--);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
