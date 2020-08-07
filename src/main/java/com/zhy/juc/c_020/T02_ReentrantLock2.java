package com.zhy.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T02_ReentrantLock2
 * @Description 使用ReentrantLock可以完成sync同样的功能，
 *              需要注意的是ReentrantLock需要手动释放锁，使用sync锁定的话如果遇到异常，jvm会自动释放锁。
 * @Author zhy
 * @Date 2020/8/5 19:39
 * @Version 1.0.0
 **/
public class T02_ReentrantLock2 {
    Lock lock  = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
                if (i==2) {
                    m2();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lock();
            System.out.println("m2...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T02_ReentrantLock2 tl = new T02_ReentrantLock2();
        new Thread(tl::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(tl::m2).start();
    }
}
