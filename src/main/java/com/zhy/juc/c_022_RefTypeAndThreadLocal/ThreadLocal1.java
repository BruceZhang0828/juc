package com.zhy.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal1
 * @Description 线程的局部变量
 * @Author zhy
 * @Date 2020/8/11 20:54
 * @Version 1.0.0
 **/
public class ThreadLocal1 {
    volatile static Person persson = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(persson.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            persson.name = "lisi";
        }).start();
    }
    static class Person{
        private String name = "zhangsan";
    }


}
