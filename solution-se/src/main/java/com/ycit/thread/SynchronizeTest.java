package com.ycit.thread;

/**
 * @author chenxiaolei
 * @date 2019/6/7
 */
public class SynchronizeTest {

    private volatile static int num = 4;

    public static void main(String[]args) {
        synchronized (SynchronizeTest.class) {
            System.out.println(1);
        }
        System.out.println(num);
    }

}
