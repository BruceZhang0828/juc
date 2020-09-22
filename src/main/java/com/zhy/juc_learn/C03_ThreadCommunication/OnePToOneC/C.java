package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

/**
 * @ClassName C
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 18:58
 * @Version 1.0.0
 **/
public class C {
    private MyStack myStack;
    public C(MyStack myStack){
        this.myStack = myStack;
    }

    public void popService(){
        System.out.println("pop = "+myStack.pop());
    }
}
