package com.zhy.juc.c_000;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: T02_HowToCreateThread
 * @Author: zhy
 * @Description: 线程的三种创建方式
 * @Date: 2020/7/16 16:59
 * @Version: 1.0
 **/
public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("MyRun");
        }
    }
    static class MyCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("myCall");
            return "Hello Callable";
        }

    }


    public static void main(String[] args) {
        new MyThread().start();

        new Thread(new MyRun()).start();

        new Thread(()->{
            System.out.println("stream");
        }).start();
        // Callable需要ExecutorService来执行
        // new Thread(new MyCall());



    }

}
