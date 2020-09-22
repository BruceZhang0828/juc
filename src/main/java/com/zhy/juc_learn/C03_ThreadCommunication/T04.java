package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName T4
 * @Description 过早使用notify
 * @Author zhy
 * @Date 2020/9/1 16:50
 * @Version 1.0.0
 **/
public class T04 {
    private static final Object lock = new Object();

    private static Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("begin wait...");
                    lock.wait();
                    System.out.println("end wait...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    private static Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify wait...");
                lock.notify();
                System.out.println("notify wait...");
            }
        }
    };

    public static void main(String[] args) {
        new Thread(runnableB).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 这里造成wait一直阻塞
        new Thread(runnableA).start();
    }
}
