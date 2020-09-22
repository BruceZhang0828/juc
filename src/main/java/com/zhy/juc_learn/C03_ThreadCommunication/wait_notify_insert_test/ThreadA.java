package com.zhy.juc_learn.C03_ThreadCommunication.wait_notify_insert_test;

/**
 * @ClassName ThreadA
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/3 22:27
 * @Version 1.0.0
 **/
public class ThreadA extends Thread{

    private DBTools dbTools;

    public ThreadA(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backUpA();
    }
}
