package com.ycit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycit.beans.StatBase;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

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

}
