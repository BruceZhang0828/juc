package com.zhy.juc.c_006;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 14:38
 * @Version: 1.0
 **/
public class T_01 implements Runnable{

    private  int count = 10;


    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            T_01 t = new T_01();
            new Thread(t,"t"+i).start();
        }
    }
}
