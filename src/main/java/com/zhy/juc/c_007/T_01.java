package com.zhy.juc.c_007;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 14:50
 * @Version: 1.0
 **/
public class T_01 {


    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+" m1  start ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"m1 end ...");
    }


    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }


    public static void main(String[] args) {
        T_01 t = new T_01();
        // new Thread(()->t.m1(),"t1").start();
        // new Thread(()->t.m2(),"t2").start();
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();
    }
}
