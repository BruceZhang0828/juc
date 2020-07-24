package com.zhy.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01_WhatIsThread
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/16 16:50
 * @Version: 1.0
 **/
public class T01_WhatIsThread {

    /**
     * @Description 继承Thread
     * @Date 16:50 2020/7/16
     * @Author zhy
     * @Param
     * @return
    **/
    private static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }


    public static void main(String[] args) {

        // T1 线程开始执行
        new T1().start();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
