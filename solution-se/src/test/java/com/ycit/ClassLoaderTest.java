package com.ycit;

import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by xlch on 2017/1/18.
 */
public class ClassLoaderTest {

    @Test
    public void jarTest() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urls) {
            System.out.println(url.toExternalForm());
        }
    }

    @Test
    public void orderTest() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader.getParent();
        }
    }

    @Test
    public void printName() {
        User user = new User();
        System.out.println(user.getClass().getName());
    }

    @Test
    public void printClassName() {
        System.out.println(User.class.getName());
    }

    @Test
    public void testN() {
        int c = 1;
        int m = c++ + 2;
        System.out.println(m);
        System.out.println(c);
//        for (int i = 0;i <3 ;++i) {
//            System.out.println(i);
//        }
    }


}
