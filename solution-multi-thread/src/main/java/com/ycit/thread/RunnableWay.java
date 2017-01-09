package com.ycit.thread;

/**
 * Created by xlch on 2017/1/9.
 */
public class RunnableWay implements Runnable {

    private String name;

    public RunnableWay(String name) {
        this.name = name;
    }

    int count = 15;

    @Override
    public void run() {

        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + " thread run ,count==" + count--);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
