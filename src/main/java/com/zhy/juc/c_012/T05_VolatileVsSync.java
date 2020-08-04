package com.zhy.juc.c_012;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: T05_VolatileVsSync
 * @Author: zhy
 * @Description: 对比上个程序发现 sync可以保证可见性和原子性,但是volatile只保证了可见性
 * @Date: 2020/7/29 12:41
 * @Version: 1.0
 **/
public class T05_VolatileVsSync {

    int count  = 0 ;

    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count ++;
        }
    }

    public static void main(String[] args) {
        T05_VolatileVsSync t = new T05_VolatileVsSync();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"t"+i));
        }


        threads.forEach(o->o.start());

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(t.count);
    }
}
