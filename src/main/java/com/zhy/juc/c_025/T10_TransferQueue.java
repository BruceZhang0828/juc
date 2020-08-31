package com.zhy.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName T10_TransferQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 14:57
 * @Version 1.0.0
 **/
public class T10_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue();
        // 需要先进行take操作
        new Thread(() -> {
            try {
                String take = linkedTransferQueue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        linkedTransferQueue.transfer("aaa");
        linkedTransferQueue.put("aaa");

        new Thread(() -> {
            try {
                // 会阻塞
                String take = linkedTransferQueue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
