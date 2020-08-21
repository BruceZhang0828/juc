package com.zhy.juc.c_023_01_Containers;

import java.util.*;

/**
 * @ClassName T02_CollectionListSetQueue
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/21 16:05
 * @Version 1.0.0
 **/
public class T02_CollectionListSetQueue {
    public static void main(String[] args) {
        Collection<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.stream().forEach(System.out::println);

        List<Integer> c2 = new ArrayList<> ();
        Set<Integer> c3 = new HashSet<>();
        Queue<Integer> c4 = new LinkedList<> ();
    }
}
