package com.zhy.juc.c_023_01_Containers;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName HelloQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/19 20:26
 * @Version 1.0.0
 **/
public class HelloQueue {
    public static void main(String[] args) {

        Queue<Integer> q = new ArrayBlockingQueue<>(2);
        q.add(0);
        q.add(1);
        // java.lang.IllegalStateException: Queue full
        q.add(2);
        q.add(3);
        System.out.println(q);
    }
}
