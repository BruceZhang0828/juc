package com.zhy.juc.c_018_AtomicXXX;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName T03_SyncVsLongAdder
 * @Description 比较sync 和 longAdder
 * @Author zhy
 * @Date 2020/8/5 16:04
 * @Version 1.0.0
 **/
public class T03_SyncVsLongAdder {
    static long count1 = 0L;
    static LongAdder count2 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[500];
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread thread:threads) {
            thread.start();
        }
        for (Thread thread:threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Sync:"+count1+" time "+(end-start));


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count2.increment();
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
        System.out.println("LongAdder:"+count1+" time "+(end-start));



    }
}
