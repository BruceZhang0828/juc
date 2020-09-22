package com.zhy.juc.c_026_00_interview.A1B2C3;

/**
 * @ClassName T07_00_sync_wait_notify
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 23:27
 * @Version 1.0.0
 **/
public class T07_00_sync_wait_notify {
    // 通过变量来 控制打印顺序
    private volatile static boolean printFlag = false;


    public static void main(String[] args) {
        Object lock = new Object();
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();
        new Thread(()->{

            while (!printFlag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (char c:
                 chars1) {
                System.out.println(c);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
        }).start();


        new Thread(()->{

            for (char c: chars2) {
                System.out.println(c);
                printFlag = true;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
        }).start();


    }
}
