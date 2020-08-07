package com.zhy.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T03_ReentrantLock3
 * @Description 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定；
 *              或者在指定的时间内，无法锁定，或在指定时间内无法锁定，下城可以决定是否继续等待
 * @Author zhy
 * @Date 2020/8/5 20:01
 * @Version 1.0.0
 **/
public class T03_ReentrantLock3 {

    Lock lock = new ReentrantLock();

    void m1(){

        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        boolean locked = false;
        try {
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2..."+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T03_ReentrantLock3 tl = new T03_ReentrantLock3();
        new Thread(tl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(tl::m2).start();
    }
}
