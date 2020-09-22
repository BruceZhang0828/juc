package com.zhy.juc.c_026_00_interview.A1B2C3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @ClassName T10_00_PipedStream
 * @Description 使用PipedStream来实现 阻塞操作
 * @Author zhy
 * @Date 2020/9/3 8:37
 * @Version 1.0.0
 **/
public class T10_00_PipedStream {

    public static void main(String[] args) throws IOException {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();

        // PipedInputStream和PipedOutStream是java语言中线程间传输数据的一种方式
        // 如果pipe满了，那么写这方会阻塞停止写入，直到有pipe空间。
        //  如果pipe空了,读这方会阻塞等待数据到来。
        //  中间状态，写方不停的写，读方不停的读。
        PipedInputStream pipedInputStream1 = new PipedInputStream();
        PipedInputStream pipedInputStream2 = new PipedInputStream();

        PipedOutputStream pipedOutputStream1 = new PipedOutputStream();
        PipedOutputStream pipedOutputStream2 = new PipedOutputStream();


        pipedInputStream1.connect(pipedOutputStream2);
        pipedInputStream2.connect(pipedOutputStream1);

        String msg = "Your Turn";

        new Thread(() -> {
            byte[] buffer = new byte[9];
            try {
                // 抢占执行
                for (char c : chars1) {
                    pipedInputStream1.read(buffer);

                    if (new String(buffer).equals(msg)) {
                        System.out.println(c);
                    }
                    pipedOutputStream1.write(msg.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            byte[] buffer = new byte[9];
            try {
                for (char c : chars2) {
                    System.out.println(c);
                    // 这里是一种阻塞
                    pipedOutputStream2.write(msg.getBytes());

                    pipedInputStream2.read(buffer);

                    if (new String(buffer).equals(msg)) {
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
