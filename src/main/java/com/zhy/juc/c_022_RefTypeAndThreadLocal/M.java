package com.zhy.juc.c_022_RefTypeAndThreadLocal;

/**
 * @ClassName M
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/11 19:16
 * @Version 1.0.0
 **/
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
