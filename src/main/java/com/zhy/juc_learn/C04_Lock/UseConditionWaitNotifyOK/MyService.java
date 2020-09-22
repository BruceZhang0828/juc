package com.zhy.juc_learn.C04_Lock.UseConditionWaitNotifyOK;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyService
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 10:52
 * @Version 1.0.0
 **/
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为"+System.currentTimeMillis());
            condition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("锁释放");
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal时间为："+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
