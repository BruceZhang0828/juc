package com.zhy.juc.c_008;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Account
 * @Author: zhy
 * @Description: 模拟
 * @Date: 2020/7/23 17:16
 * @Version: 1.0
 **/
public class Account {

    String name;

    double balance;



    public synchronized void set(String name,double balance) {
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }


    public static void main(String[] args) {
        Account account  = new Account();
        new Thread(()->account.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());

    }
}
