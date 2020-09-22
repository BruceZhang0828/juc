package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T08_00_lock_condition
 * @Description 使用condition 来实现这个问题
 *              condition.await() 用来代替 wait（）
 *              condition.single() 用来代替 notify（）
 * @Author zhy
 * @Date 2020/9/2 23:31
 * @Version 1.0.0
 **/
public class T08_00_lock_condition {

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        new Thread(()->{
            try {
                lock.lock();
                condition.await();
                for (char c: chars1) {
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

                lock.unlock();
            }


        }).start();


        new Thread(()->{
            try {
                lock.lock();
                for (char c: chars2) {
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

                lock.unlock();
            }
        }).start();
    }
}
