package com.zhy.juc.c_020;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName T06_TestCountDownLatch
 * @Description CountDownLatch 作用与join类似
 * @Author zhy
 * @Date 2020/8/6 15:15
 * @Version 1.0.0
 **/
public class T06_TestCountDownLatch {

    public static void main(String[] args) {
        useJoin();
        useCountDownLatch();
    }

    public static void useCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
                System.out.println(result);
                // 将数据减1
                 latch.countDown();
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            // 判断latch是不是为0，如果为0就不用阻塞了
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("latch end");

    }

    public static void useJoin() {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }

}
