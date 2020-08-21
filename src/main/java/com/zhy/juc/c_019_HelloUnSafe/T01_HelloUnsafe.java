package com.zhy.juc.c_019_HelloUnSafe;

// import sun.misc.Unsafe;

/**
 * @ClassName T01_HelloUnsafe
 * @Description Unsafe
 * @Author zhy
 * @Date 2020/8/5 16:31
 * @Version 1.0.0
 **/
public class T01_HelloUnsafe {

    static class M {
        private M(){

        }
        int i = 0;
    }

    public static void main(String[] args) throws InstantiationException {
        /*Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);*/
    }

}
