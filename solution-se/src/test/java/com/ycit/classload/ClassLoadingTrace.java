package com.ycit.classload;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/3/29
 */
public class ClassLoadingTrace {

    @Test
    public void test() {
//        System.out.println("11");
    }

    static {
        i = 2;
//        System.out.println(i); //illegal forward reference
    }
    static int i = 4;

}
