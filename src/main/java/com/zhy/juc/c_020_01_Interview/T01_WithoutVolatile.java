package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_WithoutVolatile
 * @Description 实现一个容器，提供两个方法，add，size
 *              写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * @Author zhy
 * @Date 2020/8/10 12:40
 * @Version 1.0.0
 **/
public class T01_WithoutVolatile {
    List list = new ArrayList();

    public void add(Object obj){
        list.add(obj);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T01_WithoutVolatile c = new T01_WithoutVolatile();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(()->{
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }

        },"t2").start();
    }
}
