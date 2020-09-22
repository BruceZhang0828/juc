package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

/**
 * @ClassName ThreadC
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 20:55
 * @Version 1.0.0
 **/
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }


    @Override
    public void run() {
        c.popService();
    }
}
