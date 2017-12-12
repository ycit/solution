package com.ycit.base;

import org.junit.Test;

/**
 * Object 巩固学习
 *
 * @author xlch
 * @Date 2017-11-22 17:55
 */
public class ObjectTest {


    @Test
    public void getClassTest() {
        String str = "123";
        Integer integer = 5;
        int[] intArray = new int[]{3,5,2};
        Integer[] integerArray = new Integer[]{3,5,2};
        byte[] byteArray = new byte[]{'3','a'};
        String[] strArray = new String[]{"aa", "bb"};
        Object[] obj = new Object[]{};
        System.out.println(str.getClass());  //  class java.lang.String
        System.out.println(integer.getClass());  // class java.lang.Integer
        System.out.println(intArray.getClass());  // class [I
        System.out.println(integerArray.getClass()); // class [Ljava.lang.Integer;
        System.out.println(byteArray.getClass());  // class [B
        System.out.println(strArray.getClass()); // class [Ljava.lang.String;
        System.out.println(obj.getClass()); // class java.lang.Object
    }

    @Test
    public void classTest() {
        Class str = String.class;  //class java.lang.String
        System.out.println(str);
        try {
            Class str2 = Class.forName("java.lang.String");
            System.out.println(str2); //class java.lang.String
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hashCodeTest() {
        String str = "hello everyone"; //保存在方法区的常量池
        String str2 = new String("hello everyone"); //对象保存在堆中，对象的引用保存在栈中
        System.out.println(str.hashCode()); //1886205177
        System.out.println(str.hashCode()); //1886205177
        System.out.println(str2.hashCode()); //1886205177
        System.out.println(str.equals(str2)); // true : 内容都相同
        System.out.println(str == str2); //false : 对象的地址不同
        System.out.println("hello everyone!".hashCode()); //-1657181624
        short s = 1;
        int i = s + 1;
        long l = 11l;
        l = l + 1;

        String[] array = new String[]{};
        System.out.println(array.length);

    }

}
