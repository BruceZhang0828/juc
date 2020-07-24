package com.zhy.juc.c_003;

/**
 * @ClassName: T_01
 * @Author: zhy
 * @Description: TODO 留下注释吧
 * @Date: 2020/7/23 14:01
 * @Version: 1.0
 **/
public class T_01 {

    private int count = 10;

    public synchronized  void m(){
        // 等同于与执行方法内的代码块 添加了synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName()+"count = "+count);
    }
}
