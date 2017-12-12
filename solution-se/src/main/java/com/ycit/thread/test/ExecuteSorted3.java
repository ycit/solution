package com.ycit.thread.test;

/**
 * 同步代码块实现
 *
 * @author xlch
 * @Date 2017-12-12 13:26
 */
public class ExecuteSorted3 {

    static int running = 1;
    static int count = 4;
    static Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                while (running != 1) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("number is :" + running);
                if (running < count) {
                    running++;
                }else {
                    running = 1;
                }
                obj.notifyAll();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                while (running != 2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("number is :" + running);
                if (running < count) {
                    running++;
                }else {
                    running = 1;
                }
                obj.notifyAll();
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (obj) {
                while (running != 3) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("number is :" + running);
                if (running < count) {
                    running++;
                } else {
                    running = 1;
                }
                obj.notifyAll();
            }
        });
        Thread t4 = new Thread(() -> {
            synchronized (obj) {
                while (running != 4) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("number is :" + running);
                if (running < count) {
                    running++;
                } else {
                    running = 1;
                }
                obj.notifyAll();
            }
        });
        t4.start();
        t2.start();
        t3.start();
        t1.start();
    }

}
