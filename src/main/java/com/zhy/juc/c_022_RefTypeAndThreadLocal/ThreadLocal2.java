package com.zhy.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal2
 * @Description ThreadLocal ：线程局部变量
 *             ThreadLocal是使用空间换时间，sync是使用时间换空间
 *             比如在hibernate中session就存在于ThreadLocal中，避免sync的使用，运行下面的程序，理解ThreadLocal
 * @Author zhy
 * @Date 2020/8/19 19:13
 * @Version 1.0.0
 **/
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();


    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println(tl.get());
        }).start();
    }


    static class Person{
        String  name = "zhangsan";

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
