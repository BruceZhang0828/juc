package com.zhy.juc.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName T03_SynchronizedList
 * @Description  工具类将List sync化
 * @Author zhy
 * @Date 2020/8/29 17:54
 * @Version 1.0.0
 **/
public class T03_SynchronizedList {
    
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        // 工具类继续sync化
        Collections.synchronizedList(lists);
    }
}
