package com.zhy.juc.c_001;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 12:53
 * @Version: 1.0
 **/
public class T_01 {
    private int count = 10;

    private Object o = new Object();


    public void m(){
        synchronized (o) { //任何线程要执行下面的代码,必须拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }
    }
}
