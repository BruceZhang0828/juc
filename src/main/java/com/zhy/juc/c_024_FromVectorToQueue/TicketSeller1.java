package com.zhy.juc.c_024_FromVectorToQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TicketSeller1
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/29 15:31
 * @Version 1.0.0
 **/
public class TicketSeller1 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号："+i);
        }
    }

    public static void main(String[] args) {
        // 存在线程安全问题 出现超卖问题
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0) {
                    String ticket = tickets.remove(0);
                    System.out.println("出票："+ticket);
                }
            }).start();
        }
    }
}
