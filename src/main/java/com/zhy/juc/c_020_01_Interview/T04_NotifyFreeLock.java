package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T04_NotifyFreeLock
 * @Description notify之后t1没有释放锁，所以需要执行wait释放锁，t2退出，
 *              t1还有没有执行的，需要notify（）叫一下t1
 * @Author zhy
 * @Date 2020/8/10 14:49
 * @Version 1.0.0
 **/
public class T04_NotifyFreeLock {
    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T04_NotifyFreeLock t = new T04_NotifyFreeLock();
        final Object o = new Object();
        new Thread(()->{
            System.out.println("t2 running");
            synchronized (o) {
                if (t.size() !=5 ) {
                    try {
                        // 叫醒t1线程
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("t2线程结束");
                // t2结束 叫醒t1
                o.notify();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 running");
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add "+i);
                    if (t.size() == 5) {
                        // 唤醒t2
                        o.notify();
                        try {
                            // 当前线程进行等待
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 结束");
            }
        },"t1").start();

    }
}
