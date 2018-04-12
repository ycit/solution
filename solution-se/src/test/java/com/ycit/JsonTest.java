package com.ycit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycit.beans.StatBase;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * json 测试
 *
 * @author xlch
 * @create 2017-08-03 10:38
 */
public class JsonTest {

    @Test
    public void jsonTest()throws IOException {
        String result = "[{\"name\":4,\"value\":2},{\"name\":5,\"value\":3}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<StatBase> objects = objectMapper.readValue(result, List.class);
        System.out.println(objects);
    }

    @Test
    public void nullTest() {
        StatBase statBase = null;
        if (statBase == null) {
            statBase = null;
        }
    }

    @Test
    public void strTest() {
        String str = String.format("%d",20170903);
        System.out.println(str);
        System.out.println(str);

        System.out.println(String.valueOf(21312).substring(String.valueOf(21312).length()-1));

        Pattern pattern = Pattern.compile("\\d{8}");
        System.out.println(pattern.matcher("20170a93").find());
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(-4 << 2);
        System.out.println(-4 >> 2);
        System.out.println(Integer.toBinaryString(-4 >>> 2));
        System.out.println(-4 >>> 2);
        System.out.println(4 >> 2);
        System.out.println(4 >>> 2);
        System.out.println((1 >> 4));
        System.out.println(1 >>> 4);
        System.out.println(-16 >>> 4);
        System.out.println(2^3);
        int[] array = {2,3,4,4,3,5,6,6,5};
        int v = 0;
        for (int i = 0;i < array.length;i++) {
            v ^= array[i];
        }
        System.out.println("只出现一次的数是:" + v);
        Map<String, String> map = new HashMap<>();
        map.put(null,null);
        map.put(null,null);
        map.put(null,null);
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry:entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key is ===" + key);
            System.out.println("value is ===" + value);
        }
        System.out.println(-140%8); // 取余 -4
        System.out.println(Math.floorMod(-140, 8)); // 取模 4
    }

    @Test
    public void sTest() {
        int i = 1;
        System.out.println(i++);
    }

}
