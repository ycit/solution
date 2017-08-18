package com.ycit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xlch on 2016/12/27.
 */
public class StrTest {

    public static void main(String[]args) {
        String str = "dev";
        String format = String.format("app.%s.properties",str);
        System.out.println(format);
    }

    @Test
    public void math() {
        List<String> list = new ArrayList<>();
        int total = 99;
        int times = (int)Math.ceil((double) total/(double)10);
        int time = (int)Math.ceil( total/10);
        if (total%10==0) {
            for (int i = 0;i<times;i++) {
            }
        }else {

        }
        System.out.println(times);

        Object [] arr = new Object[]{"123","","90d"};
        Arrays.sort(arr);
    }

}
