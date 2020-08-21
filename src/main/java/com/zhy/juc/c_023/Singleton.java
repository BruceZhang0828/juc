package com.zhy.juc.c_023;

/**
 * @ClassName Singleton
 * @Description 线程安全的单例模式：
 *                  阅读文章：http://www.cnblogs.com/xudong-bupt/p/3433643.html
 *
 * @Author zhy
 * @Date 2020/8/19 20:20
 * @Version 1.0.0
 **/
public class Singleton {
    private Singleton(){
        System.out.println("Singleton");
    }

    private static class Inner{
        private static Singleton s = new Singleton();
    }

    public static Singleton getInstance() {
        return Inner.s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                System.out.println(Singleton.getInstance());
            }).start();
        }
    }
}
