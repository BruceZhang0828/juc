package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName T02
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 12:50
 * @Version 1.0.0
 **/
public class T02 {
    static class Service{
        public void testMethod(Object lock){
            synchronized (lock) {
                try {
                    System.out.println("wait begin");
//                    lock.wait();
                    Thread.sleep(1000);
                    System.out.println("wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void syncNotifyMethod(){

        }
    }

    static class Thread1 extends Thread {
        private Object lock;
        public Thread1(Object lock){
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            Service service = new Service();
            service.testMethod(lock);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread1 a = new Thread1(lock);
        a.start();
        Thread1 b = new Thread1(lock);
        b.start();
    }
}
