package com.zhy.juc.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T01_HelloVolatile
 * @Author: zhy
 * @Description: 认识Volatile
 * @Date: 2020/7/27 12:55
 * @Version: 1.0
 **/
public class T01_HelloVolatile {

    volatile boolean running  = true;


    void m() {
        System.out.println("m start");
        while (running) {

        }

        System.out.println("m end");
    }


    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
