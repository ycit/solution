package com.ycit.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author chenxiaolei
 * @date 2019/6/13
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 3, 5, 2};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{4, 9, 3, 5, 2};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[]{4, 9, 3, 5, 2};
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{4, 9, 3, 5, 2};
        shellSort(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    /**
     * 冒泡排序
     * 时间复杂度:平均O(n^2)
     * 空间复杂度:O(1)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        int minIndex, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * 时间复杂度 O(n^2)
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int preIndex, current;
        for (int i = 1; i< arr.length; i++) {
            preIndex = i - 1;
            current =arr[i];
            while ( preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[]arr) {
        int len = arr.length;
        for (int gap = (int)Math.floor(len/2);gap > 0;gap = (int)Math.floor(gap/2)) {
            for (int i = gap; i < len;i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j-gap]) {
                    arr[j] = arr[j-gap];
                    j=j-gap;
                }
                arr[j] = current;
            }
        }
    }

}
