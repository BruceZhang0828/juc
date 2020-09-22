package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyStack
 * @Description 存 -取 手递手操作1:1
 * @Author zhy
 * @Date 2020/9/2 18:46
 * @Version 1.0.0
 **/
public class MyStack {
    private List list = new ArrayList();

    public synchronized void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString = " + Math.random());
            this.notify();
            System.out.println("push = " + list.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String pop() {

        String returnValue = "";
        try {
            if (list.size() == 0) {
                System.out.println("pop操作中的：" + Thread.currentThread().getName() + "的线程wait状态");
                this.wait();
            }
            returnValue = ""+list.get(0);
            list.remove(0);
            System.out.println("pop: "+list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return returnValue;
    }


    public static void main(String[] args) {

    }
}
