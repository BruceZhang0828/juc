package com.zhy.juc.c_025;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T06_ArrayBlockingQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 12:55
 * @Version 1.0.0
 **/
public class T06_ArrayBlockingQueue {
    // 固定数量的队列
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("put操作" + i);
        }
        // 会抛出错误 java.lang.IllegalStateException: Queue full
//        strs.add("aaa");
        // 满了 之后会阻塞
//        strs.put("aaa");
        // 这个操作会返回是不是操作成功
//        boolean result = strs.offer("aaa");
        //在规定的时间查看是否能够插入数据 有返回值
        boolean result = strs.offer("aaa", 10, TimeUnit.SECONDS);
        System.out.println(result);
        System.out.println(strs);
    }
}
