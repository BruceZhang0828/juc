package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName T05_00_AtomicInteger
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 0:16
 * @Version 1.0.0
 **/
public class T05_00_AtomicInteger {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghij".toCharArray();

        new Thread(() -> {
            for (char c : chars1) {
                while (ai.get() != 1) {
                }
                System.out.println(c);
                ai.set(2);
            }
        }, "t1").start();


        new Thread(() -> {
            for (char c : chars2) {
                while (ai.get() != 2) {
                }
                System.out.println(c);
                ai.set(1);
            }
        }, "t2").start();
    }
}
