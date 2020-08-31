package com.zhy.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName T04_ConcurrentQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/29 18:00
 * @Version 1.0.0
 **/
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 100; i++) {
            // 如果超出队列限制 offer方法不会抛出异常而是返回false
//            strs.offer("a" + i);
            // 如果超出队列限制 add方法会抛出异常
            strs.add("a" + i);
        }

        System.out.println(strs);

        System.out.println(strs.size());
        // 从队列中移除数据
        System.out.println(strs.poll());
        System.out.println(strs.size());

        // 从队列中取出数据，但是队列中数据量不变
        System.out.println(strs.peek());
        System.out.println(strs.size());
    }
}
