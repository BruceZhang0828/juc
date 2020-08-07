package com.zhy.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T05_ReentrantLock5
 * @Description ReentrantLock 可以做为一种公平锁
 * @Author zhy
 * @Date 2020/8/5 20:47
 * @Version 1.0.0
 **/
public class T05_ReentrantLock5 extends Thread {
    // 设置为公平锁
    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
    }
}
