package com.ycit;

import com.ycit.thread.RunnableWay;
import com.ycit.thread.ThreadWay;
import org.junit.Test;

/**
 * Created by xlch on 2017/1/9.
 */
public class MultiThreadTest {

    @Test
    public void threadTest() {

        ThreadWay threadWay1 = new ThreadWay("A");
        ThreadWay threadWay2 = new ThreadWay("B");
        threadWay1.start();
        threadWay2.start();

    }

    @Test
    public void runnableTest() {
        RunnableWay way1 = new RunnableWay("1");
        RunnableWay way2 = new RunnableWay("2");
        new Thread(way1).start();
        new Thread(way2).start();
    }

    @Test
    public void runnable() {
        RunnableWay runnableWay = new RunnableWay("1");
        new Thread(runnableWay,"3").start();
        new Thread(runnableWay,"4").start();
    }

}
