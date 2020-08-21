package com.zhy.juc.c_021_01_interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyContainer1
 * @Description 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 *                     能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *                     使用wait和notify/notifyAll来实现
 * @Author zhy
 * @Date 2020/8/10 18:54
 * @Version 1.0.0
 **/
public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();

    final private int MAX = 10;
    private int count = 0;



    public synchronized void put (T t){
        while (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;

        while (lists.size() == 0) {
            try {
                // 释放锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        t = lists.removeFirst();
        count--;
        // 通知生产者线程开始生产
        this.notifyAll();
        return t;
    }


    public static void main(String[] args) {
        MyContainer1<String> container = new MyContainer1();

        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(container.get());
                }
            },"c"+1).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    container.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
