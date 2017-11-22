package com.ycit.section2;

/**
 * 排序模版
 *
 * @author xlch
 * @Date 2017-10-20 9:39
 */
public abstract class SortTemplate {

    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)  < 0 ;
    }

    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void show(Comparable[] a) {
        for (Comparable comparable:a) {
            System.out.println(comparable);
        }
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1, length = a.length; i < length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
