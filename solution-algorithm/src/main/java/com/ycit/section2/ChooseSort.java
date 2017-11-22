package com.ycit.section2;

/**
 * 选择排序
 *
 * @author xlch
 * @Date 2017-10-20 9:49
 */
public class ChooseSort extends SortTemplate {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0, length = a.length; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
        System.out.println(isSorted(a));
        show(a);
    }

    public static void main(String[] args) {
        Integer[] a = {23, 45, 41, 54, 19, 77, 32, 64, 95, 28, 10, 82};
        SortTemplate sortTemplate = new ChooseSort();
        sortTemplate.sort(a);
    }
}
