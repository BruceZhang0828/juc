package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @ClassName T13_TransferQueue
 * @Description
 * @Author zhy
 * @Date 2020/9/3 12:51
 * @Version 1.0.0
 **/
public class T13_TransferQueue {

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(()->{
            for (char c:chars1) {
                try {
                    System.out.println(queue.take());
                    queue.transfer(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{
            for (char c:chars2) {
                try {
                    // 要是都是take 在前，就造成阻塞了
                    queue.transfer(c);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
