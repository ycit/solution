package com.ycit.jvm;

import org.junit.Test;

/**
 * @author uk
 * 2019/4/13 8:31
 */
public class StackOverFlowTest {
    StackOverFlowTest test = new StackOverFlowTest();

    @Test
    public void stackTest() {


    }

    public static void main(String[]args) {
        new StackOverFlowTest();
    }

}
