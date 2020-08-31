package com.zhy.juc.c_024_FromVectorToQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TicketSeller1
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/29 15:31
 * @Version 1.0.0
 **/
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号：" + i);
        }
    }

    public static void main(String[] args) {
        // 使用ConcurrentQueue提高并发性
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                while (true) {
                    String ticket = tickets.poll();
                    if (ticket == null) {
                        break;
                    } else {
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("出票：" + ticket);
                    }
                }
            }).start();
        }
    }
}
