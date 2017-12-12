package com.ycit.thread;

/**
 * 测试函数
 *
 * @author xlch
 * @Date 2017-11-24 13:32
 */
public class MainTest {

    public static void main(String[] args) {
        Storage2 storage = new Storage2();
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
//        Producer p5 = new Producer(storage);
//        Producer p6 = new Producer(storage);
//        Producer p7 = new Producer(storage);
//        Producer p8 = new Producer(storage);
//        Producer p9 = new Producer(storage);
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);
        Consumer c4 = new Consumer(storage);
        Consumer c5 = new Consumer(storage);
        p1.setNum(40);
        p2.setNum(80);
        p3.setNum(40);
        p4.setNum(60);
        c1.setNum(20);
        c2.setNum(10);
        c3.setNum(10);
        c4.setNum(30);
        c5.setNum(40);
        c1.start();
        p1.start();
        p2.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        p3.start();
        p4.start();
    }

}
