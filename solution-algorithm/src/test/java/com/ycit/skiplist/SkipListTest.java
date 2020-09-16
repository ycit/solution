package com.ycit.skiplist;

import org.junit.Test;

/**
 * 跳表测试
 *
 * @author chenxiaolei
 * @date 2020/1/21
 */
public class SkipListTest {

    @Test
    public void skipListT() {
        SkipList2 skipList = new SkipList2();
        skipList.insert(22, 1);
        skipList.insert(19, 2);
        skipList.insert(7, 4);
        skipList.insert(3, 1);
        skipList.insert(37, 3);
        skipList.printAll_beautiful();
    }

}
