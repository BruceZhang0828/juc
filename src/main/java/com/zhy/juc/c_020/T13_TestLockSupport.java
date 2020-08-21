package com.zhy.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T13_TestLockSupport
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/10 11:14
 * @Version 1.0.0
 **/
public class T13_TestLockSupport {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

                if (i == 5) {
                    System.out.println("暂停一下");
                    LockSupport.park();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        // 进行
        LockSupport.unpark(t);
    }
}
