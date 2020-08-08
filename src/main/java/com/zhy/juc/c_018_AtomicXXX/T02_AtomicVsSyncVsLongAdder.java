package com.zhy.juc.c_018_AtomicXXX;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class T02_AtomicVsSyncVsLongAdder {
    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();


    public static void main(String[] args) throws InterruptedException {
        // 创建线程数组
        Thread[] threads = new Thread[1000];
        // 添加线程任务
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count1.incrementAndGet();
                }
            });
        }
        // 统计执行时间
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();
        // 一般数据快
        System.out.println("Atomic: " + count1.get() + " time " + (end-start));

        // 使用sync
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    synchronized (lock) {
                        count2++;
                    }
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread thread:threads) {
            thread.start();
        }
        for (Thread thread:threads) {
            thread.join();
        }
        end = System.currentTimeMillis();
        // 一般数据量比longadder快，但是数据大的话 会特别慢
        System.out.println("sync: " + count2 + " time " + (end-start));

        // 使用longAdd

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread thread:threads) {
            thread.start();
        }
        for (Thread thread:threads) {
            thread.join();
        }
        end = System.currentTimeMillis();
        // 执行大量数据 快
        System.out.println("LongAdder: " + count3.longValue() + " time " + (end-start));
        
    }



}
