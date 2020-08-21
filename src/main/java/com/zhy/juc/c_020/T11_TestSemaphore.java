package com.zhy.juc.c_020;

import java.util.concurrent.Semaphore;

/**
 * @ClassName T11_TestSemaphore
 * @Description 信号量 permits数量的线程正常，之外的线程需要等待之前的线程执行semaphore.release();
 * @Author zhy
 * @Date 2020/8/10 10:37
 * @Version 1.0.0
 **/
public class T11_TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2,true);

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T1 running ...");
                Thread.sleep(200);
                System.out.println("T1 Running ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T3 running...");
                Thread.sleep(200);
                System.out.println("T3 running...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
