package com.zhy.juc_learn.C03_ThreadCommunication.InheritableThreadLocal1;

/**
 * @ClassName Run
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/4 12:59
 * @Version 1.0.0
 **/
public class Run {

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main线程中取值：" + Tools.t1.get());
                Thread.sleep(100);
            }

            Thread.sleep(500);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
