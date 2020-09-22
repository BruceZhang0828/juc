package com.zhy.juc.c_026_01_ThreadPool;

import java.util.concurrent.Executor;

/**
 * @ClassName T01_MyExecutor
 * @Description 认识Executor
 * @Author zhy
 * @Date 2020/9/16 19:38
 * @Version 1.0.0
 **/
public class T01_MyExecutor implements Executor {


    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
