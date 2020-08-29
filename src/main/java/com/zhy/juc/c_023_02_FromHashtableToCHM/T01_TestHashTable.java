package com.zhy.juc.c_023_02_FromHashtableToCHM;

import java.util.Hashtable;
import java.util.UUID;

/**
 * @ClassName T01_TestHashTable
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/25 22:47
 * @Version 1.0.0
 **/
public class T01_TestHashTable {
    static Hashtable<UUID, UUID> ht = new Hashtable<UUID, UUID>();

    static UUID[] keys = new UUID[Constants.COUNT];
    static UUID[] values = new UUID[Constants.COUNT];

    static final int THREAD_CONUT = Constants.THREAD_COUNT;

    static {
        for (int i = 0; i < Constants.COUNT; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start;
        int gap = Constants.COUNT / THREAD_CONUT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < start + gap; i++) {
                ht.put(keys[i], values[i]);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_CONUT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * (Constants.COUNT / THREAD_CONUT));
        }

        for (Thread thread :
                threads) {
            thread.start();
        }


        for (Thread thread :
                threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(ht.size());

       start = System.currentTimeMillis();
        // gradle 编译这里出现问题
        // Process 'command 'D:/Program Files/java/jdk1.8.0_191/bin/java.exe'' finished with non-zero exit value 1
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000000; j++) {
                    ht.get(keys[10]);
                }
            });
        }

        for (Thread thread:
             threads) {
            thread.start();
        }

        for (Thread thread:
                threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
