package com.zhy.juc_learn.C04_Lock.UseConditionWaitNotifyError;

/**
 * @ClassName Run
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/7 10:17
 * @Version 1.0.0
 **/
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        // java.lang.IllegalMonitorStateException
        // condition.await() 调用必须要用 lock.lock()
    }
}
