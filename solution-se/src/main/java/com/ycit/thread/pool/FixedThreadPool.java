package com.ycit.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定量线程池
 *
 * @author xlch
 * @Date 2017-12-08 16:36
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 1; i <= 100; i++) {
            final int index = i;
            executor.execute(() -> {
                System.out.println("current thread name is ======" + Thread.currentThread().getName());
                System.out.println("execute sort is ======" + index);
                if (index == 5) {
                    throw new RuntimeException("异常测试");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

}
