package com.zhy.juc.c_025;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName T01_ConcurrentMap
 * @Description http://blog.csdn.net/sunxianghuang/article/details/52221913
 *              http://www.educity.cn/java/498061.html
 *              阅读concurrentskiplistmap
 * @Author zhy
 * @Date 2020/8/29 17:05
 * @Version 1.0.0
 **/
public class T01_ConcurrentMap {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new Hashtable<>();
        // 高并发并且排序
//        Map<String, String> map = new ConcurrentSkipListMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);

        long start = System.currentTimeMillis();
        for(int i=0; i<ths.length; i++) {
            ths[i] = new Thread(()->{
                for(int j=0; j<10000; j++) {
                    map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                }
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());
    }
}
