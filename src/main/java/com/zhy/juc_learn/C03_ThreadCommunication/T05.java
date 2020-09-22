package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName T05
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 17:13
 * @Version 1.0.0
 **/
public class T05 {

    private static final Object lock = new Object();


    private static boolean isFirstRun = false;


    private static Runnable t1 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                while(isFirstRun == false) {
                    try {
                        System.out.println("wait begin "+System.currentTimeMillis());
                        lock.wait();
                        System.out.println("wait end "+System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    private static Runnable t2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("begin notify");
            lock.notify();
            System.out.println("end notify");
            isFirstRun = true;
        }
    };

    public static void main(String[] args) {
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        // 造成阻塞
    }
}
