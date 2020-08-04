package com.zhy.juc.c_000;

/**
 * @ClassName: T05_StopThread
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/29 16:37
 * @Version: 1.0
 **/
public class T05_StopThread {


    static class MyThread extends Thread {
        volatile boolean running = false;
        @Override
        public void run() {
            while (!running) {
                System.out.println(getName()+"is running");
                try {
                    sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println("week up from block...");
                    running = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println("Starting thread...");
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupt thread ..."+t.getName());
        // 设置共享变量为true
        // t.running = true;
        // 阻塞时退出 阻塞状态
        t.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping application...");
    }
}
