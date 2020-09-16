package com.ycit.gc;

import org.junit.Test;

/**
 * full gc 测试
 *
 * @author keda
 * @date 2019/3/1
 */
public class FullGcTest {

    @Test
    public void arrayGc() {
        while (true) {
            Stack stack = new Stack();
            stack.push(1);
            stack.pop(1);
        }
    }

    class Stack{
        Object data[] = new Object[1000];
        int top = 0;
        public void push(Object o){
            data[top++] = o;
        }
        public Object pop(Object o){
            return data[--top];
        }
    }

}
