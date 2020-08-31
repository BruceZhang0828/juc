package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName T01
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 16:36
 * @Version 1.0.0
 **/
public class T01 {

    public static void main(String[] args) {
        try {
            // 没有锁调用的java.lang.IllegalMonitorStateException
            String newStr = new String();
            newStr.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
