package com.zhy.juc.c_009;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 15:33
 * @Version: 1.0
 **/
public class T_01 {
    private int count = 10;
    synchronized void m1(){
        System.out.println("m1 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        count--;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2" +"count ="+count);
    }


    public static void main(String[] args) {
        T_01 t = new T_01();
        for (int i = 0; i < 10; i++) {
            new Thread(t::m1,"t").start();
        }

    }
}
