package com.zhy.juc.c_026_00_interview.A1B2C3;

/**
 * @ClassName T06_00_sync_wait_notify
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 23:11
 * @Version 1.0.0
 **/
public class T06_00_sync_wait_notify {

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                for (char c:chars1) {

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(c);
                    lock.notify();

                }
                // 这里必须
                lock.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c:chars2) {
                    System.out.println(c);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.notify();
            }
        }).start();



    }
}
