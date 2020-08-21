package com.zhy.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @ClassName T01_NormalReference
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/11 19:17
 * @Version 1.0.0
 **/
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();
        
        System.in.read();
    }
}
