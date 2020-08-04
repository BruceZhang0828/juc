package com.zhy.juc.c_012;

/**
 * @ClassName: T03_VolatileReference
 * @Author: zhy
 * @Description:  volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 * @Date: 2020/7/27 17:00
 * @Version: 1.0
 **/
public class T03_VolatileReference {

    private static class Data {
        int a,b;

        public Data(int a,int b){
            this.a = a;
            this.b = b;
        }
    }

    volatile static Data data;


    public static void main(String[] args) {

        Thread writer = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                data = new Data(i, i);
            }
        });

        Thread reader = new Thread(()->{
            while (data == null) {}
            int x = data.a;
            int y = data.b;
            if(x != y) {
                System.out.printf("a = %s, b=%s%n", x, y);
            }
        });


        reader.start();
        writer.start();


        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("end");
    }
}
