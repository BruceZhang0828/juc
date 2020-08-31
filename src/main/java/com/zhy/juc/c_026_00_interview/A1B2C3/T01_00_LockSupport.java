package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T01_00_LockSupport
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 19:06
 * @Version 1.0.0
 **/
public class T01_00_LockSupport {
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        char[] chars1 = {'1','2','3','4','5','6','7','8','9'};
        char[] chars2 = {'a','b','c','d','e','f','g','h','j'};

        t1 = new Thread(()->{
            for (int i = 0; i < chars1.length; i++) {
                System.out.println(chars1[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for (int i = 0; i < chars2.length; i++) {
                LockSupport.park();
                System.out.println(chars2[i]);
                LockSupport.unpark(t1);
            }
        },"t2");


        t1.start();
        t2.start();

    }
}
