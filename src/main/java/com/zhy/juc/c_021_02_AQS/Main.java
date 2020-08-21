package com.zhy.juc.c_021_02_AQS;

import java.util.concurrent.locks.Lock;

/**
 * @ClassName Main
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/11 16:21
 * @Version 1.0.0
 **/
public class Main {

    public static int m = 0;

    public static Lock lock = new MLock();


    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }

        for (Thread t:
             threads) {
            t.start();
        }

        for (Thread t:
                threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(m);
    }
}
