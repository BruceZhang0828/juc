package com.zhy.juc.c_026_00_interview.A1B2C3;

/**
 * @ClassName T03_00_cas
 * @Description TODO 请写类描述
 * @Author zhy
 * @Date 2020/8/31 23:56
 * @Version 1.0.0
 **/
public class T03_00_cas {
    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun t = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghij".toCharArray();

        new Thread(() -> {
            for (char c : chars1) {

                while (ReadyToRun.T1!=t){
                    // 阻塞
                }
                System.out.println(c);
                t = ReadyToRun.T2;
            }
        }).start();


        new Thread(() -> {
            for(char char1:chars2){
                while (ReadyToRun.T2!=t){}
                System.out.println(char1);
                t = ReadyToRun.T1;
            }
        }).start();


    }
}
