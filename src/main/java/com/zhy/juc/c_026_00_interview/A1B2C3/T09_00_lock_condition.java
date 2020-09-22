package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T09_00_lock_condition
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 23:41
 * @Version 1.0.0
 **/
public class T09_00_lock_condition {

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : chars1) {
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            try {
                lock.lock();
                for (char c : chars2) {
                    System.out.println(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();
    }
}
