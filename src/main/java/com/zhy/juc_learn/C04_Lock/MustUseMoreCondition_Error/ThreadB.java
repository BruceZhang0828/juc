package com.zhy.juc_learn.C04_Lock.MustUseMoreCondition_Error;

/**
 * @ClassName ThreadB
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 11:58
 * @Version 1.0.0
 **/
public class ThreadB extends Thread {

    private MyService myService;
    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitB();
    }
}
