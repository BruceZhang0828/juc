package com.zhy.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * @ClassName c_022_RefTypeAndThreadLocal
 * @Description 软引用：软应用是用来描述一些还有用但并非必须的对象。
 *              对于软引用关联着的对象，在系统将要发生内存溢出异常之前，
 *              将会把这些对象列进回收范围进行第二次回收。如果这次回收还没有足够的内存，才会抛出内存溢出异常
 *              -Xmx20M
 * @Author zhy
 * @Date 2020/8/11 19:20
 * @Version 1.0.0
 **/
public class T02_SoftReference {

    public static void main(String[] args) {
        SoftReference<Byte[]> m = new SoftReference<>(new Byte[1024*1024*10]);

        System.out.println(m.get());

        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        // 再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024*1024*15];

        System.out.println(m.get());

        // 软引用非常适合缓存使用
    }


}
