package com.zhy.juc.c_023_02_FromHashtableToCHM;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName T03_TestSynchronizedHashMap
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/26 6:53
 * @Version 1.0.0
 **/
public class T03_TestSynchronizedHashMap {
    static Map<UUID,UUID> hm = Collections.synchronizedMap(new HashMap<UUID,UUID>());
    static int count = Constants.COUNT;
    static int THREAD_COUNT = Constants.THREAD_COUNT;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];

    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start;
        int gap = count/THREAD_COUNT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < start+gap; i++) {
                hm.put(keys[i],values[i]);
            }
        }
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i*(count/THREAD_COUNT));
        }

        for (Thread thread:threads) {
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
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(hm.size());


        // 读取测试
        start = System.currentTimeMillis();


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000000; j++) {
                    hm.get(keys[10]);
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

       /* for(Thread t : threads) {
            t.start();
        }*/

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
