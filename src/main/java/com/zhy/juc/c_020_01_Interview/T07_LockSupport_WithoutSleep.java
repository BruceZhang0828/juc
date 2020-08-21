package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T07_LockSupport_WithoutSleep
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/10 16:36
 * @Version 1.0.0
 **/
public class T07_LockSupport_WithoutSleep {
    volatile List lists = new ArrayList();

    static Thread t1 = null, t2 = null;

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T07_LockSupport_WithoutSleep t = new T07_LockSupport_WithoutSleep();

        t2 = new Thread(() -> {
            System.out.println("t2 running");
            if (t.size() != 5) {
                // 暂停当前线程
                LockSupport.park();
            }
            System.out.println("t2 end");
            LockSupport.unpark(t1);
        });
        t1 = new Thread(() -> {
            System.out.println("t1 runnig");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1 end");
        });

        t1.start();
        t2.start();
    }
}
