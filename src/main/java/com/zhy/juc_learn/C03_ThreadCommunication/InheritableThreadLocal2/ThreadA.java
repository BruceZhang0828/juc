package com.zhy.juc_learn.C03_ThreadCommunication.InheritableThreadLocal2;

/**
 * @ClassName ThreadA
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/4 12:56
 * @Version 1.0.0
 **/
public class ThreadA extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("获取线程ThreadA中的值：" + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
