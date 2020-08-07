package com.zhy.juc.c_020;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_ReentrantLock1
 * @Description reentrantlock用于替代synchronized 本例中，由于m1锁定this，只有m1执行完毕的时候m2才能执行
 *              这里为了复习sync的用法
 * @Author zhy
 * @Date 2020/8/5 17:17
 * @Version 1.0.0
 **/
public class T01_ReentrantLock1 {

    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) {
                m2();
            }
        }
    }


    synchronized void m2() {
        System.out.println("m2 ...");
    }


    public static void main(String[] args) {
        T01_ReentrantLock1 tl = new T01_ReentrantLock1();
        new Thread(tl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(tl::m2).start();
    }



}
