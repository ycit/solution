package com.ycit.classload;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/3/26
 */
public class ClassLoaderTest {

    @Test
    public void treeTest() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        if (classLoader != null) {
            System.out.println(classLoader.toString());
            System.out.println(classLoader.getParent().toString());
        }
    }

}
