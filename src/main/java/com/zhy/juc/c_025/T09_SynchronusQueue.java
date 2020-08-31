package com.zhy.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName T09_SynchronusQueue
 * @Description 容量为0
 * @Author zhy
 * @Date 2020/8/31 14:51
 * @Version 1.0.0
 **/
public class T09_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();
        // 需要先进行take操作
        new Thread(() -> {
            try {
                String take = strs.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(strs.size());
        // 阻塞等待消费者消费
//        strs.put("aaa");
        // 这里会阻塞
        // strs.put("bbb");
        // add 操作会抛出异常
        strs.add("aaa");
        System.out.println(strs.size());
    }
}
