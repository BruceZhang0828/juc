package com.zhy.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName T07_TestCyclicBarrier
 * @Description 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
 * @Author zhy
 * @Date 2020/8/6 16:45
 * @Version 1.0.0
 **/
public class T07_TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20);
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("ren man le"));

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
