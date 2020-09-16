package com.ycit.section1;


import java.util.Arrays;

/**
 * 二分查找
 *
 * @author xlch
 * @Date 2017-10-19 11:20
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lower = 0;
        int higher = a.length - 1;
        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2;
            if (key < a[mid]) {
                higher = mid - 1;
            } else if (key > a[mid]) {
                lower = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
