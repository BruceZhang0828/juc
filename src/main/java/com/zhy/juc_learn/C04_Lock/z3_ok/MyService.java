package com.zhy.juc_learn.C04_Lock.z3_ok;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyService
 * @Description 任务处理类
 * @Author zhy
 * @Date 2020/9/7 10:30
 * @Version 1.0.0
 **/
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("锁释放了！");
        }
    }
}

