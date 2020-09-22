package com.zhy.juc_learn.C03_ThreadCommunication.OnePToOneC;

/**
 * @ClassName P
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/2 18:57
 * @Version 1.0.0
 **/
public class P {
    private MyStack myStack;
    public P(MyStack myStack){
        this.myStack = myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
