package com.zhy.juc.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T05_LinkedBlockingQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/29 18:25
 * @Version 1.0.0
 **/
public class T05_LinkedBlockingQueue {
    // 没有界限的
    static BlockingQueue<String> strs = new LinkedBlockingQueue<String>();
    static Random random = new Random();


    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    // 会进行阻塞增加
                    //如果满了，就会等待
                    strs.put("a"+i);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();


        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"task - "+strs.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
