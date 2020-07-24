package com.zhy.juc.c_002;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 13:53
 * @Version: 1.0
 **/
public class T_01 {

    private int count = 10;

    public void m(){
        // 任何线程要执行西边的代码,必须要先拿到this的锁
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }
    }
}
