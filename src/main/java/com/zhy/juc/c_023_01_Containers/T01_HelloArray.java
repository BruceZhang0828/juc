package com.zhy.juc.c_023_01_Containers;

import java.util.Arrays;

/**
 * @ClassName T01_HelloArray
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/21 16:02
 * @Version 1.0.0
 **/
public class T01_HelloArray {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        Arrays.stream(a).map(i ->i+1).forEach(i-> System.out.println(i));
    }
}
