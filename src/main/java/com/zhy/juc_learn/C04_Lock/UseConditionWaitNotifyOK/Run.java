package com.zhy.juc_learn.C04_Lock.UseConditionWaitNotifyOK;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Run
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 11:01
 * @Version 1.0.0
 **/
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myService.signal();
    }
}
