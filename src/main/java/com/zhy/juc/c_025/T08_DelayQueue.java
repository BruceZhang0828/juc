package com.zhy.juc.c_025;

import java.util.concurrent.*;

/**
 * @ClassName T08_DelayQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 14:27
 * @Version 1.0.0
 **/
public class T08_DelayQueue {
    static BlockingQueue<MyTask> tasks = new DelayQueue<>();

    static class MyTask implements Delayed {
        String name;
        long runningTime;

        public MyTask(String name, long rt) {
            this.name = name;
            this.runningTime = rt;
        }


        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {

                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {

                return 1;
            } else {

                return 0;
            }

        }


        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }


        @Override
        public String toString() {
            return this.name + " " + this.runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask("t1", now + 1000);
        MyTask t2 = new MyTask("t2", now + 2000);
        MyTask t3 = new MyTask("t3", now + 1500);
        MyTask t4 = new MyTask("t4", now + 2500);
        MyTask t5 = new MyTask("t5", now + 500);
        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take());
        }

    }
}
