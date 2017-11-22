package com.ycit;

import org.junit.Test;

/**
 * 选择排序
 *
 * @author xlch
 * @Date 2017-10-19 17:51
 */
public class ChooseSort {

    @Test
    public void chooseTest() {
        int[] a = {23,45,41,54,19,77,32,64,95,28,10,82};
        for (int i = 0, length = a.length; i <length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                    j = i;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        for (int i = 0, length = a.length; i <length; i++) {
            System.out.println(a[i]);
        }
    }


}
