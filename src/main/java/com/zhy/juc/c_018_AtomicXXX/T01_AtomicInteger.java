package com.zhy.juc.c_018_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomX类解决++的问题，AtomX类本身方法都是原子性的；
 * 但不能保证多个方法连续调用的原子性
 */
public class T01_AtomicInteger {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    int count = 0;

    /**
     * 进行自增 by AtomicInteger
     */
    void m(){
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
        }
    }

    /**
     * 进行自增 by synchronized
     */
    void m2(){
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }


    public static void main(String[] args) {
        T01_AtomicInteger t1 = new T01_AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t1::m2,"t"+i));
        }
        // 启动线程
        threads.stream().forEach(thread -> thread.start());
        // 保证线程都执行完成
        threads.stream().forEach(thread->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 这里是不是不用
        System.out.println(t1.count);
    }

}
