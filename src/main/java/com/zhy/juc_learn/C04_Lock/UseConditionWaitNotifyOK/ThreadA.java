package com.zhy.juc_learn.C04_Lock.UseConditionWaitNotifyOK;

/**
 * @ClassName ThreadA
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 10:59
 * @Version 1.0.0
 **/
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
