package com.ycit.section1;

/**
 * 二分查找
 *
 * @author xlch
 * @Date 2017-10-19 11:20
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] whileList = {23,45,86,34,57,29,10,72,93,24,59,74,36,68,16,24};
//        Arrays.sort(whileList);

//        int[] whileList = In.readInts(args[0]);
//        Arrays.sort(whileList);
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
//            if (rank(key, whileList) == -1) {
//                StdOut.println(key);
//            }
//        }
    }

}
