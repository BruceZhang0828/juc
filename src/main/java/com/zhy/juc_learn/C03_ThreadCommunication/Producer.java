package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName Productor
 * @Description 生产者消费者模式 - 生产者
 * @Author zhy
 * @Date 2020/9/2 8:27
 * @Version 1.0.0
 **/
public class Producer {

    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }


    public void setValue() throws InterruptedException {
        synchronized (lock) {
            if (!(ValueObject.value.equals(""))) {
                System.out.println("执行了wait");
                lock.wait();
            }

            String value = System.currentTimeMillis() + "-" + System.nanoTime();
            System.out.println("生产者穿创建的值是："+value);
            ValueObject.value = value;
            lock.notify();
        }
    }

}
