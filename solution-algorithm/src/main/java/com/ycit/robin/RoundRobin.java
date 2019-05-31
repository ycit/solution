package com.ycit.robin;

/**
 * 轮询算法
 *
 * @author uk
 * 2019/4/7 7:05
 */
public class RoundRobin {

    public static void main(String[]args) {
        int[]array = new int[]{5,34,35,24,567,23,45457,457,2342,6768,342};
        int index = 0;
        for (int i = 0,len = array.length;i < len;i++){
            int nextIndex = (index + 1)%len;
            index = nextIndex;
            System.out.println("index = " + index + ", value = " + array[index]);
        }
    }

}
