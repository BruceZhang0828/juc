package com.zhy.juc_learn.C03_ThreadCommunication.wait_notify_insert_test;

/**
 * @ClassName DBTools
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/3 18:30
 * @Version 1.0.0
 **/
public class DBTools {
    private static volatile boolean preIsA = true;

    public synchronized void backUpA() {
        try {
            while (preIsA) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("*****");
            }

            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void backUpB() {

        try {
            while (!preIsA) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("=====");
            }

            preIsA = false;

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
