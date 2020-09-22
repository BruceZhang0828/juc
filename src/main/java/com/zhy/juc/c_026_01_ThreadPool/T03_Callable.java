package com.zhy.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

/**
 * @ClassName T03_Callable
 * @Description 认识callable对Runable进行扩展
 * @Author zhy
 * @Date 2020/9/16 19:55
 * @Version 1.0.0
 **/
public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello callable";
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
