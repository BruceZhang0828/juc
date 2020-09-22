package com.zhy.juc_learn.C03_ThreadCommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName T06
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/1 18:39
 * @Version 1.0.0
 **/
public class T06 {

    static class ValueObject {
        public static List list = new ArrayList<>();
    }

    static class Add{
        private Object lock;
        public Add(Object lock){
            this.lock = lock;
        }

        public void add(){
            synchronized (lock) {
                ValueObject.list.add("anyString");
                lock.notifyAll();
            }
        }
    }

    static class Subtract {
        private Object lock;
        public Subtract(Object lock){
            this.lock = lock;
        }

        public void subtract(){
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    try {
                        System.out.println("wait begin ThreadName ="+Thread.currentThread().getName());
                        lock.wait();
                        System.out.println("wait end ThreadName ="+Thread.currentThread().getName());
                        ValueObject.list.remove(0);
                        System.out.println("list size = "+ValueObject.list.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ThreadAdd extends Thread{
        private Add add;
        public ThreadAdd(Add add) {
            super();
            this.add = add;
        }

        @Override
        public void run() {
            add.add();
        }
    }


    static class ThreadSub extends Thread{
        private Subtract subtract;
        public ThreadSub(Subtract subtract) {
            super();
            this.subtract = subtract;
        }

        @Override
        public void run() {
            subtract.subtract();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock  = new Object();

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSub threadSub1 = new ThreadSub(subtract);
        threadSub1.setName("subtract1");
        threadSub1.start();

        ThreadSub threadSub2 = new ThreadSub(subtract);
        threadSub2.setName("subtract2");
        threadSub2.start();

        Thread.sleep(1000);

        ThreadAdd threadAdd  = new ThreadAdd(add);
        threadAdd.setName("add");
        threadAdd.start();


    }
}
