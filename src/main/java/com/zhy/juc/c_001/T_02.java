package com.zhy.juc.c_001;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T_02
 * @Description
 * @Author zhy
 * @Date 2020/8/21 9:19
 * @Version 1.0.0
 **/
public class T_02 {



    static class HasSelfPrivateNum {
        private int num = 0;

        public synchronized void  addI(String userName){
            try {
                if ("a".equals(userName)) {
                    num = 100;
                    System.out.println("a set over!");
                    TimeUnit.SECONDS.sleep(1);
                }else {
                    num = 200;
                    System.out.println("b set over!");
                }
                System.out.println(userName+" : "+num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        HasSelfPrivateNum hasnm = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasnm);
        threadA.start();
        ThreadB threadB = new ThreadB(hasnm);
        threadB.start();
    }

    static class ThreadA extends Thread{
        private HasSelfPrivateNum numRef;
        public ThreadA(HasSelfPrivateNum numRef){
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("a");
        }
    }

    static class ThreadB extends Thread{
        private HasSelfPrivateNum numRef;
        public ThreadB(HasSelfPrivateNum numRef){
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("b");
        }
    }
}
