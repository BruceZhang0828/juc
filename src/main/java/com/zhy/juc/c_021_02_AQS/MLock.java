package com.zhy.juc.c_021_02_AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MLock
 * @Description 通过AQS实现自定义锁，目前仅实现了lock和unlock
 * @Author zhy
 * @Date 2020/8/11 16:22
 * @Version 1.0.0
 **/
public class MLock implements Lock {
    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1L);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1L);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
