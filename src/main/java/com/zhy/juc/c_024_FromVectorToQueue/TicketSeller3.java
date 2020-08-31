package com.zhy.juc.c_024_FromVectorToQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TicketSeller1
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/29 15:31
 * @Version 1.0.0
 **/
public class TicketSeller3 {
    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号：" + i);
        }
    }

    public static void main(String[] args) {
        // 存在线程安全问题 出现超卖问题
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                while (true) {
                    // 就像这个程序，判断size和进行remove必须是一整个的原子操作
                    synchronized (tickets) {
                        if (tickets.size() <= 0) {
                            break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String ticket = tickets.remove(0);
                        System.out.println("出票：" + ticket);
                    }
                }
            }).start();
        }
    }
}
