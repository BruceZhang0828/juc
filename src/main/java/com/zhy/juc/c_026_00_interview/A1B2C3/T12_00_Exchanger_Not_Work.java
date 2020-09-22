package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.Exchanger;

/**
 * @ClassName T12_00_Exchanger_Not_Work
 * @Description 通过 Exchanger 来实现 但是有问题
 * @Author zhy
 * @Date 2020/9/3 12:42
 * @Version 1.0.0
 **/
public class T12_00_Exchanger_Not_Work {

    public static Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();

        new Thread(()->{
            for (int i = 0; i < chars1.length; i++) {
                try {
                    System.out.println(chars1[i]);
                    exchanger.exchange("T1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{
            for (int i = 0; i < chars2.length; i++) {
                try {
                    exchanger.exchange("T2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(chars2[i]);
            }
        }).start();


    }
}
