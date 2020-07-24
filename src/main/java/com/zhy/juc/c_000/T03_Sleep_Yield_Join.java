package com.zhy.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T03_Sleep_Yield_Join
 * @Author: zhy
 * @Description: sleep方法:
 *                  当前线程睡眠多少ms
 *
 * @Date: 2020/7/22 10:11
 * @Version: 1.0
 **/
public class T03_Sleep_Yield_Join {

    private static final Object lock = new Object();
    public static void main(String[] args) {
//        testYield();
        testJoin();
    }

    static void testSleep(){
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 100; i++) {
                    System.out.println("A"+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 100; i++) {
                    System.out.println("-----B"+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    static void testYield(){
        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("A" + i);
                if(i%10 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("-----B" + i);
                if(i%10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin() {
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 100;i++) {
                System.out.println("A"+i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 100; i++) {
                System.out.println("B"+i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
    }




}
