package com.zhy.juc.c_013_LockOptimization;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FineCoarseLock
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/29 12:55
 * @Version: 1.0
 **/
public class FineCoarseLock {

    int count  = 0;

    synchronized void m1() {
        // do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // need sync
        // 业务中只有这个地方需要加锁不应该给整个方法加锁
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        // do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    void m2(){
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //need sync
        synchronized (this){
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
