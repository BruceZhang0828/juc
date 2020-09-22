package com.zhy.juc_learn.C04_Lock.MustUseMoreCondition_Error;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MySerivce
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 11:10
 * @Version 1.0.0
 **/
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为"+System.currentTimeMillis()
                    +"ThreaName:"+Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitA时间为"+System.currentTimeMillis()
                    +"ThreaName:"+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin waitB 时间为："+System.currentTimeMillis()+"ThreadName:"+Thread.currentThread().getName());
            condition.await();
            System.out.println("end waitB 时间为："+System.currentTimeMillis()+"ThreadName: "+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
