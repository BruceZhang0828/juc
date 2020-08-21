package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T03_NotifyHoldingLock
 * @Description 这里使用wait和notify做到，wait会释放锁，而notify不会释放锁
 *              需要注意的是，运用这种方法，必须要保证t2先执行，也就是首先让t2监听才可以
 *              但是输出结果并不是size=5时t2退出，而是t1结束时t2才接收到通知而退出
 * @Author zhy
 * @Date 2020/8/10 13:51
 * @Version 1.0.0
 **/
public class T03_NotifyHoldingLock {
    volatile List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {
        T03_NotifyHoldingLock t = new T03_NotifyHoldingLock();

        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock) {
                System.out.println("t2");
                if (t.size()!=5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2执行完成");
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add" +i);
                    if (t.size() == 5) {
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
    }
}
