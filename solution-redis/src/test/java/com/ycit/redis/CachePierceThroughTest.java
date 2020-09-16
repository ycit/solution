package com.ycit.redis;

import com.google.common.collect.ImmutableList;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.security.Key;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 缓存穿透 test
 *
 * @author chenxiaolei
 * @date 2019/6/3
 */
public class CachePierceThroughTest {

    private static Map<String, String> cache = new HashMap<>();

    private static Map<String, String> db = new HashMap<>();

    CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    public void test()throws Exception {
        List<String> integers = ImmutableList.of("1","2","3","4","5","6","7","8","9","10");
        Iterator<String> iterator = integers.iterator();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(()-> {
                if (iterator.hasNext()) {
                    String key = iterator.next();
                    String value = cache.get(key);
                    if (StringUtils.isBlank(value)) {
                        System.out.println("cache 中不存在该值");
                        String dbValue = db.get(key);
                        if (StringUtils.isBlank(dbValue)) {
                            System.out.println("db中 不存在该值 ...");
                            cache.put(key, "null");
                        } else {
                            System.out.println("db exist value ...");
                        }
                    } else {
                        System.out.println("cache exist value");
                    }
                }
            });
            thread.start();
        }
        Thread.sleep(5000);
        List<String> strings = ImmutableList.of("1","2","3","4","5","6","7","8","9","10");
        Iterator<String> s2 = strings.iterator();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(()-> {
                if (s2.hasNext()) {
                    String key = s2.next();
                    String value = cache.get(key);
                    if (StringUtils.isBlank(value)) {
                        System.out.println("cache 中不存在该值");
                        String dbValue = db.get(key);
                        if (StringUtils.isBlank(dbValue)) {
                            System.out.println("db中 不存在该值 ...");
                        } else {
                            System.out.println("db exist value ...");
                        }
                    } else {
                        System.out.println("cache exist value");
                    }
                }
            });
            thread.start();
        }

        countDownLatch.await(5, TimeUnit.SECONDS);
    }

    /**
     * 缓存穿透：使用 bloomFilter 过滤
     * @param args
     * @throws Exception
     */
    public static void main(String[]args)throws Exception {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 2);
        List<String> integers = ImmutableList.of("1","2","3","4","5","6","7","8","9","10");
        bloomFilter.put("2");
        bloomFilter.put("4");
        bloomFilter.put("7");
        Iterator<String> iterator = integers.iterator();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(()-> {
                if (iterator.hasNext()) {
                    String key = iterator.next();
                    boolean exist = bloomFilter.mightContain(key);
                    if (!exist) { //不存在，一定不存在
                        System.out.println(String.format("db key %s　不存在, break ...", key));
                        return;
                    }
                    String value = cache.get(key);
                    if (StringUtils.isBlank(value)) {
                        System.out.println("cache 中不存在该值");
                        String dbValue = db.get(key);
                        if (StringUtils.isBlank(dbValue)) {
                            System.out.println("db中不存在该值 ...");
//                            cache.put(key, "null");
//                            bloomFilter.put(key);
                        } else {
                            System.out.println("db exist value ...");
                        }
                    } else {
                        System.out.println(String.format("cache key %S exist value, values is %s ...", key, value));
                    }
                }
            });
            thread.start();
        }
//        Thread.sleep(5000);
//        List<String> strings = ImmutableList.of("1","2","3","4","5","6","7","8","9","10");
//        Iterator<String> s2 = strings.iterator();
//        for(int i=0;i<10;i++) {
//            Thread thread = new Thread(()-> {
//                if (s2.hasNext()) {
//                    String key = s2.next();
//                    String value = cache.get(key);
//                    if (StringUtils.isBlank(value)) {
//                        System.out.println("cache 中不存在该值");
//                        String dbValue = db.get(key);
//                        if (StringUtils.isBlank(dbValue)) {
//                            System.out.println("db中 不存在该值 ...");
//                        } else {
//                            System.out.println("db exist value ...");
//                        }
//                    } else {
//                        System.out.println(String.format("cache exist value, values is %s ...", value));
//                    }
//                }
//            });
//            thread.start();
//        }
    }

}
