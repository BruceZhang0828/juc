package com.zhy.juc.c_000;

/**
 * @ClassName T06_HowToOrderThread
 * @Description 如何顺序执行线程
 * @Author zhy
 * @Date 2020/8/5 16:41
 * @Version 1.0.0
 **/
public class T06_HowToOrderThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("t1执行");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2执行");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3执行");
        });


        t2.start();
        t3.start();
        t1.start();


    }
}
