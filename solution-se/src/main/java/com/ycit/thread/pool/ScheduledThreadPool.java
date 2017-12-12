package com.ycit.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时或者周期线程池
 *
 * @author xlch
 * @Date 2017-12-08 17:15
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        for (int i = 1; i <= 100; i++) {
            final int index = i;
            executor.schedule(() -> {
                System.out.println("current thread name is :" + Thread.currentThread().getName());
                System.out.println("execute sort is :" + index);
            }, 2, TimeUnit.SECONDS);
        }
        executor.shutdown();
    }

}
