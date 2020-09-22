package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName TestProAndCon
 * @Description 测试消费者和生产者
 * @Author zhy
 * @Date 2020/9/2 8:39
 * @Version 1.0.0
 **/
public class TestProAndCon {

    static class ThreadP extends Thread{
        private Producer producer;

        public ThreadP(Producer producer) {
            this.producer = producer;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    producer.setValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadC extends Thread{
        private Consumer consumer;

        public ThreadC(Consumer consumer) {
            this.consumer = consumer;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    consumer.getValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP threadP = new ThreadP(producer);
        ThreadC threadC = new ThreadC(consumer);
        threadP.start();
        threadC.start();
    }
}
