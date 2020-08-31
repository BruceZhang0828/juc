package com.zhy.juc.c_025;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName T02_CopyOnWriteList
 * @Description 写时复制容器 copy on write
 * 多线程环境下,写时的效率低，读时效率高
 * 适合写少读多的环境
 * @Author zhy
 * @Date 2020/8/29 17:39
 * @Version 1.0.0
 **/
public class T02_CopyOnWriteList {

    public static void main(String[] args) {
//        List<String> lists = new ArrayList<>();
//        List<String> lists = new Vector<>();
        List<String> lists1 = new ArrayList<>();
        List<String> lists = Collections.synchronizedList(lists1);
//        List<String> lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] tds = new Thread[100];
        for (int i = 0; i < tds.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lists.add("a" + r.nextInt(10000));
                    }
                }
            };
            tds[i] = new Thread(task);
        }

        runAndComputeTime(tds);

        System.out.println(lists.size());
    }

    private static void runAndComputeTime(Thread[] tds) {
        long startTime = System.currentTimeMillis();
        Arrays.asList(tds).forEach(t -> t.start());
        Arrays.asList(tds).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long endTime = System.currentTimeMillis();
        System.out.println("执行线程组的时间："+(endTime - startTime));
    }


}
