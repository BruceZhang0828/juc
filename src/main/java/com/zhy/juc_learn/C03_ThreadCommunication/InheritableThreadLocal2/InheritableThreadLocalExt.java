package com.zhy.juc_learn.C03_ThreadCommunication.InheritableThreadLocal2;

/**
 * @ClassName InheritableThreadLocalExt
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/9/4 12:52
 * @Version 1.0.0
 **/
public class InheritableThreadLocalExt extends InheritableThreadLocal{
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+"我在子线程加的";
    }
}
