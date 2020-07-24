package com.zhy.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T04_ThreadState
 * @Author: zhy
 * @Description: 线程状态
 * @Date: 2020/7/22 13:01
 * @Version: 1.0
 **/
public class T04_ThreadState {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i = 0; i < 10; i++) {

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());
    }
}
