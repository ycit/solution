package com.ycit.section2;

/**
 * 排序模版
 *
 * @author xlch
 * @Date 2017-10-20 9:39
 */
public abstract class SortTemplate {

    /**
     * 排序算法，有不同的实现
     * @param a 可比较的数组
     */
    public abstract void sort(Comparable[] a);

    /**
     * 比较两个对象的大小
     * v < w 则 返回 true
     * v > w 则 返回 false
     * @param v 比较对象1
     * @param w 比较对象2
     * @return true or false
     */
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)  < 0 ;
    }

    /**
     * 交换数组中两个元素
     * @param a 需要交换的数组
     * @param i 位置1
     * @param j 位置2
     */
    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 打印数组中元素
     * @param a 需要打印的数组
     */
    public void show(Comparable[] a) {
        for (Comparable comparable:a) {
            System.out.println(comparable);
        }
    }

    /**
     * 判断数组是否被真确排序
     * @param a 被检验数组
     * @return true or false
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1, length = a.length; i < length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
