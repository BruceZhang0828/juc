package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

/**
 * @ClassName ThreadC
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 20:55
 * @Version 1.0.0
 **/
public class ThreadP extends Thread {
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }


    @Override
    public void run() {
        p.pushService();
    }
}
