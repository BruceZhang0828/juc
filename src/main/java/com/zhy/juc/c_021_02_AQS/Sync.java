package com.zhy.juc.c_021_02_AQS;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @ClassName Sync
 * @Description AQS
 * @Author zhy
 * @Date 2020/8/11 16:23
 * @Version 1.0.0
 **/
public class Sync  extends AbstractQueuedLongSynchronizer {
    /**
     * @Description 尝试获取锁
     * @Date 16:27 2020/8/11
     * @Author zhy
     * @Param [arg]
     * @return boolean
     **/
    @Override
    protected boolean tryAcquire(long arg) {
        // cas操作
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }
    /**
     * @Description 释放当前线程
     * @Date 16:27 2020/8/11
     * @Author zhy
     * @Param [arg]
     * @return boolean
     **/
    @Override
    protected boolean tryRelease(long arg) {
        // 清空线程
        setExclusiveOwnerThread(null);
        setState(0L);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
