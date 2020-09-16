package com.ycit;

/**
 * 素数
 *
 * @author chenxiaolei
 * @date 2019/3/25
 */
public class PrimeNum {

    public static void main(String[] args) {
        System.out.println(isPrime(6));
    }

    public static int isPrime(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            int j = 2;
            for (; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                total++;
            }
        }
        return total;
    }

    public static boolean isPrime(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                System.out.println(j);
                return false;
            }
        }
        return true;

    }

}
