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
            classLoader = classLoader.getParent();
        }
    }

    @Test
    public void test11() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();	//获得加载ClassLoaderTest.class这个类的类加载器
        while(loader != null) {
            System.out.println(loader);
            loader = loader.getParent();	//获得父类加载器的引用
        }
        System.out.println(loader);
    }

    @Test
    public void printName() {
        User user = new User();
        System.out.println(user.getClass().getName());
    }

    @Test
    public void propertyTest() {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty(" java.class.path"));
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
