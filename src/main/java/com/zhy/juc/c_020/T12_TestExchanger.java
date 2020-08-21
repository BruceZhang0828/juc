package com.zhy.juc.c_020;

import java.util.concurrent.Exchanger;

/**
 * @ClassName T12_TestExchanger
 * @Description 线程之间协作工具 两个线程可以交换彼此的数据
 *               如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange
 * @Author zhy
 * @Date 2020/8/10 10:45
 * @Version 1.0.0
 **/
public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<> ();

    public static void main(String[] args) {

        new Thread(()->{
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+s);
        },"t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+s);
        },"t2").start();


    }
}
