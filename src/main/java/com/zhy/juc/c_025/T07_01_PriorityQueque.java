package com.zhy.juc.c_025;

import java.util.PriorityQueue;

/**
 * @ClassName T07_01_PriorityQueque
 * @Description 有排序的 基于优先级的无界优先队列。
 * @Author zhy
 * @Date 2020/8/31 13:11
 * @Version 1.0.0
 **/
public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("c");
        queue.add("a");
        queue.add("z");
        queue.add("d");
        queue.add("f");

        int size = queue.size();
        // 通过完全二叉树实现一个小顶堆
        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
    }
}
