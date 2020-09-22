package com.zhy.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName T02_ExecutorService
 * @Description 认识ExecutorService,阅读API文档
 *              认识submit方法，扩展了execute方法，具有一个返回值
 * @Author zhy
 * @Date 2020/9/16 19:50
 * @Version 1.0.0
 **/
public class T02_ExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
