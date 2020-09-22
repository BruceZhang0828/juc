package com.zhy.juc_learn.C03_ThreadCommunication.ConditionTestMoreMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyService
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/4 16:16
 * @Version 1.0.0
 **/
public class MyService {

    private Lock lock = new ReentrantLock();

    public void methodA(){

        lock.lock();
        try {

        }finally {
            lock.unlock();
        }

    }
}
