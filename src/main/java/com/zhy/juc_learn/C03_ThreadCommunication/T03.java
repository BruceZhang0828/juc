package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName T03
 * @Description 测试wait（long）
 * @Author zhy
 * @Date 2020/9/1 16:20
 * @Version 1.0.0
 **/
public class T03 {

    static class MyRunnable {
        static private Object lock = new Object();

        static private Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("wait begin: " + System.currentTimeMillis());
                        lock.wait(5000);
                        System.out.println("wait end: " + System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        static private Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {

                    System.out.println("notify begin: " + System.currentTimeMillis());
                    lock.notify();
                    System.out.println("notify end: " + System.currentTimeMillis());

                }
            }
        };

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(MyRunnable.r1);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(MyRunnable.r2);
        t2.start();
    }
}
