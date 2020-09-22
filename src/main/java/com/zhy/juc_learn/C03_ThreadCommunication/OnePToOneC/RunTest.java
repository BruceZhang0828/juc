package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

import com.zhy.juc.c_022_RefTypeAndThreadLocal.M;

/**
 * @ClassName RunTest
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 20:57
 * @Version 1.0.0
 **/
public class RunTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p = new P(myStack);
        C c = new C(myStack);

        ThreadC threadC = new ThreadC(c);
        ThreadP threadP = new ThreadP(p);

        threadC.start();
        threadP.start();
    }
}
