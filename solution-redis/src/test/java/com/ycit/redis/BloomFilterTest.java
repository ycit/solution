package com.ycit.redis;

import com.google.common.hash.BloomFilter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenxiaolei
 * @date 2019/5/31
 */
public class BloomFilterTest {

    private static Map<String, String> cache = new HashMap<>();

    private static Map<String, String> db = new HashMap<>();

    static {
        db.put("name", "xlch");
    }

    @Test
    public void guavaBloomFilterTest() {
//        BloomFilter bloomFilter = new BloomFilter<String>();
    }

    private static Lock lock = new ReentrantLock();

    /**
     * 缓存穿透：查询数据库中一定不存在的值
     */
    @Test
    public void cachePierceThrough() {

    }

    /**
     * 缓存击穿：缓存失效，同一时间，大量请求涌入，直接打到 db,导致 db 压力过大
     */
    @Test
    public void cacheBreakDownTest() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String v = cache.get("name");
                if (StringUtils.isBlank(v)) {
                    System.out.println("不存在缓存,db 获取");
                    v = db.get("name");
                    cache.put("name", v);
                }
            }).start();
        }
    }

    public static void main(String[] arg) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
//                System.out.println(String.format("thread %s ... start", Thread.currentThread().getName()));
                String value = getValueByKey("name");
//                System.out.println(String.format("name is %s", v));
            }).start();
        }
    }

    private static String getValueByKey(String key) {
        String v = cache.get(key);
        if (StringUtils.isBlank(v)) {
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取到锁， ...");
                    v = cache.get("name");
                    if (StringUtils.isBlank(v)) {
                        System.out.println("不存在缓存,db 获取");
                        //模拟获取时间较长
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cache.put("name", db.get("name"));
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " 未获取到锁，进入睡眠 ...");
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                v = getValueByKey(key);
                if (StringUtils.isNotBlank(v)) {
                    System.out.println("睡眠后，获取到值，");
                } else {
                    System.out.println("睡眠后，未获取到值，");
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " 缓存中获取");
        }
        return v;
    }

    @Test
    public void cacheBreakDownSolveTest()throws Exception {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
               String value = getValueByKey("name");
            });
            t.start();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

}
