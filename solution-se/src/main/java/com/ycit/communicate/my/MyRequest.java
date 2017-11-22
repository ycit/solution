package com.ycit.communicate.my;

import java.io.IOException;
import java.io.InputStream;

/**
 * 模拟请求的处理
 *
 * @author xlch
 * @create 2017-09-25 11:16
 */
public class MyRequest {

    private InputStream in;
    private String uri;

    public MyRequest(InputStream in) {
        this.in = in;
    }

    public void parse() {
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[1024];
        try {
            i = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char)buffer[j]);
        }
        System.out.println(request.toString());
        uri = this.parseUri(request.toString());
    }

    private String parseUri(String requestStr) {
        int index1, index2;
        index1 = requestStr.indexOf(' ');
        System.out.println("index1 is :" + index1);
        if (index1 != -1) {
            index2 = requestStr.indexOf(' ', index1 + 1);
            System.out.println("index2 is " + index2);
            if (index2 > index1){
                System.out.println("uri is :" + requestStr.substring(index1 + 1, index2));
                return requestStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }
}
