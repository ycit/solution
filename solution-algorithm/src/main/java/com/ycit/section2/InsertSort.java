package com.ycit.section2;

/**
 * 插入排序
 *
 * @author xlch
 * @Date 2017-10-20 10:22
 */
public class InsertSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        for (int i = 1, length = a.length; i < length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        System.out.println(isSorted(a));
        show(a);
    }

    public static void main(String[] args) {
        Integer[] a = {23, 45, 41, 54, 19, 77, 32, 64, 95, 28, 10, 82};
        SortTemplate sortTemplate = new InsertSort();
        sortTemplate.sort(a);
    }

}
