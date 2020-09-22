package com.zhy.juc_learn.C03_ThreadCommunication.wait_notify_insert_test;

/**
 * @ClassName Run
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/3 22:29
 * @Version 1.0.0
 **/
public class Run {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i = 0; i < 20; i++) {
            ThreadB threadB = new ThreadB(dbTools);
            threadB.start();
            ThreadA threadA = new ThreadA(dbTools);
            threadA.start();
        }
    }
}
