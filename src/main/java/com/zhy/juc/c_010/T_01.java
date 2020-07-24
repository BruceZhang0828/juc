package com.zhy.juc.c_010;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: 一个同步方法可以调用另外一个同步方法，
 *               一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 *               也就是说synchronized获得的锁是可重入的
 *               这里是继承中有可能发生的情形，子类调用父类的同步方法
 * @Date: 2020/7/24 16:51
 * @Version: 1.0
 **/
public class T_01 {

    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Tt tt = new Tt();
        for (int i = 0; i < 10; i++) {
            new Thread(tt::m,"t"+i).start();
        }

    }

}

class Tt extends T_01 {
    @Override
    synchronized void m() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
