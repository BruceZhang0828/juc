package com.zhy.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T02_WithVolatile
 * @Description 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，
 *              而且，如果在if 和 break之间被别的线程打断，得到的结果也不精确
 * @Author zhy
 * @Date 2020/8/10 12:52
 * @Version 1.0.0
 **/
public class T02_WithVolatile {

   // volatile List list = new ArrayList();

    volatile List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object obj){
        list.add(obj);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T02_WithVolatile c = new T02_WithVolatile();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(()->{
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2结束");

        },"t2").start();
    }
}
