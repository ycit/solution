package com.ycit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycit.beans.StatBase;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
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
        System.out.println(pattern.matcher("20170a93").find());;
    }

}
