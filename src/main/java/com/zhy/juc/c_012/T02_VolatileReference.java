package com.zhy.juc.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T02_VolatileReference
 * @Author: zhy
 * @Description: Volatile 引用类型(包括数组) 只能保证引用本身的可见性,不能保证内部字段的可见性
 * @Date: 2020/7/27 16:51
 * @Version: 1.0
 **/
public class T02_VolatileReference {
    boolean running = true;

    volatile static T02_VolatileReference T = new T02_VolatileReference();

    public void  m(){
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }


    public static void main(String[] args) {
        new Thread(T::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }

}
