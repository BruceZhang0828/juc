package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName TestProAndCon
 * @Description 测试消费者和生产者
 * @Author zhy
 * @Date 2020/9/2 8:39
 * @Version 1.0.0
 **/
public class TestProAndCon02 {

    static class ThreadP extends Thread{
        private Producer2 producer2;

        public ThreadP(Producer2 producer) {
            this.producer2 = producer;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    producer2.setValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadC extends Thread{
        private Consumer2 consumer;

        public ThreadC(Consumer2 consumer) {
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

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Producer2 producer = new Producer2(lock);
        Consumer2 consumer = new Consumer2(lock);

        Thread[] threadPs = new Thread[2];
        Thread[] threadCs = new Thread[2];
        ThreadP threadP1 = new ThreadP(producer);
        threadP1.setName("生产者1");
        threadP1.setName("生产者2");
        ThreadP threadP2 = new ThreadP(producer);
        threadPs[0] = threadP1;
        threadPs[1] = threadP2;
        ThreadC threadC1 = new ThreadC(consumer);
        ThreadC threadC2 = new ThreadC(consumer);
        threadCs[0] = threadC1;
        threadCs[1] = threadC2;
        threadC1.setName("消费者1");
        threadC2.setName("消费者2");
        for (int i = 1; i < threadCs.length; i++) {
            threadPs[i].start();
            threadCs[i].start();
        }
        Thread.sleep(5000);  

        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName()+":"+threadArray[i].getState());
        }
        

    }
}
