package com.zhy.juc.c_020;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName T10_TestReadWriteLock
 * @Description 读写锁 读操作多 写操作少
 * @Author zhy
 * @Date 2020/8/10 10:15
 * @Version 1.0.0
 **/
public class T10_TestReadWriteLock {

    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            // 这里模拟读操作
            System.out.println("read over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void write(Lock lock,int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            // 模拟写操作
            System.out.println("write over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Runnable read = () -> read(readLock);
        Runnable writer = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writer).start();
        }
    }
}
