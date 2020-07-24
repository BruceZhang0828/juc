package com.zhy.juc.c_005;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 14:20
 * @Version: 1.0
 **/
public class T_01 implements Runnable{

    private volatile int count = 100;


    @Override
    public  void run() {
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }


    public static void main(String[] args) {
        T_01 t = new T_01();

        for (int i = 0; i < 100; i++) {
            new Thread(t,"T"+i).start();
        }
    }
}
