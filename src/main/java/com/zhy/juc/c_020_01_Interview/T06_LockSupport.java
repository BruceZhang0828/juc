package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T06_LockSupport
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/10 16:14
 * @Version 1.0.0
 **/
public class T06_LockSupport {
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T06_LockSupport t = new T06_LockSupport();

        Thread t2 = new Thread(()->{
            System.out.println("t2 running");
            if (t.size()!=5) {
                // 暂停当前线程
                LockSupport.park();
            }
            System.out.println("t2 end");
        });

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 runnig");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add "+i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 end");
        }).start();
    }
}
