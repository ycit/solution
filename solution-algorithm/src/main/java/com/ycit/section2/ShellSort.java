package com.ycit.section2;

/**
 * 希尔排序
 *
 * @author xlch
 * @Date 2017-10-25 10:04
 */
public class ShellSort extends SortTemplate {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
                h = h / 3;
            }
        }
        System.out.println(isSorted(a));
        show(a);
    }

    public static void main(String[] args) {
        Integer[] a = {23, 45, 41, 54, 19, 77, 32, 64, 95, 28, 10, 82};
        SortTemplate sortTemplate = new ShellSort();
        sortTemplate.sort(a);
    }
}
