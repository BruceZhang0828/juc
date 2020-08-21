package com.zhy.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

/**
 * @ClassName T03_WeakReference
 * @Description 弱引用遭到gc就会回收
 * @Author zhy
 * @Date 2020/8/11 19:46
 * @Version 1.0.0
 **/
public class T03_WeakReference {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());


        ThreadLocal<M> tl = new ThreadLocal<> ();
        tl.set(new M());
        tl.remove();

    }
}
