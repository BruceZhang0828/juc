package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName T04_00_BlockingQueue
 * @Description 利用blockqueue的阻塞操作来实现
 * @Author zhy
 * @Date 2020/9/1 0:08
 * @Version 1.0.0
 **/
public class T04_00_BlockingQueue {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);


    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghij".toCharArray();

        new Thread(()->{
            for (char c: chars1) {
                System.out.println(c);
                try {
                    q1.take();
                    q2.put("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            // 这个顺序 首先要获取这个执行
            try {
                // t1没有执行完成 t2的take操作阻塞
                q2.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (char c : chars2) {
                System.out.println(c);
            }

            try {
                // 让t1的阻塞失效
                q1.put("t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2").start();
    }
}
