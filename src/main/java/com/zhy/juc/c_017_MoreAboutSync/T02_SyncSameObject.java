package com.zhy.juc.c_017_MoreAboutSync;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某个对象0，如果0的属性发生改变，不影响锁的使用；
 * 但是如果o变成了另一个对象，则锁定的对象发生改变，应该避免将锁定的引用变成另外的对象
 */
public class T02_SyncSameObject {
    Object lock  = new Object();

    void m() {
        synchronized (lock) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());
            }
        }
    }


    public static void main(String[] args) {
        T02_SyncSameObject t = new T02_SyncSameObject();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::m, "t2");
        // 所对象发生改变，所以t2线程得以执行，如果去掉这段话，线程2将永远得不到锁，不能执行
        // t.lock = new Object();

        t2.start();
    }
}
