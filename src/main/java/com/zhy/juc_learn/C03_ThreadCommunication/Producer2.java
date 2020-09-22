package com.zhy.juc_learn.C03_ThreadCommunication;

/**
 * @ClassName Productor
 * @Description 生产者消费者模式 - 生产者 - 假死的状态（有方法执行了wait（）但是没有执行notify（）操作）
 * @Author zhy
 * @Date 2020/9/2 8:27
 * @Version 1.0.0
 **/
public class Producer2 {

    private Object lock;

    public Producer2(Object lock) {
        this.lock = lock;
    }


    public void setValue() throws InterruptedException {
        synchronized (lock) {
            if (!(ValueObject.value.equals(""))) {
                System.out.println("执行了wait");
                lock.wait();
            }

            System.out.println("生产者:" +Thread.currentThread().getName());
            String value = System.currentTimeMillis() + "-" + System.nanoTime();
            System.out.println("生产者穿创建的值是："+value);
            ValueObject.value = value;
            lock.notify();
        }
    }

}
