package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName Consume
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 8:35
 * @Version 1.0.0
 **/
public class Consumer2 {

    private Object lock;

    public Consumer2(Object lock) {
        this.lock = lock;
    }

    public void getValue() throws InterruptedException {
        synchronized (lock) {
            if ("".equals(ValueObject.value)) {
                System.out.println("消费者："+Thread.currentThread().getName()+"执行了wait");
                lock.wait();

            }
            System.out.println("消费者："+Thread.currentThread().getName()+"正在Runnable");
            System.out.println("消费者消耗的值是："+ValueObject.value);
            ValueObject.value = "";
            lock.notify();
        }
    }
}
