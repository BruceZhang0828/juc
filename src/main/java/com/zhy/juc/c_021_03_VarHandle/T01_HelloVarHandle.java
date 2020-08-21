package com.zhy.juc.c_021_03_VarHandle;

import java.lang.invoke.MethodHandles;

/**
 * @ClassName T01_HelloVarHandle
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/11 18:56
 * @Version 1.0.0
 **/
public class T01_HelloVarHandle {
    int x = 8;

//    private static VarHandle varHandle;

   /* static {
        try {
            varHandle = MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class,"x",int.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        /*T01_HelloVarHandle t = new T01_HelloVarHandle();

        System.out.println((int)varHandle.get(t));

        varHandle.set(t,9);

        varHandle.compareAndSet(t,9,10);
        System.out.println(t.x);

        varHandle.set(t, 10);
        System.out.println(t.x);*/
    }
}
