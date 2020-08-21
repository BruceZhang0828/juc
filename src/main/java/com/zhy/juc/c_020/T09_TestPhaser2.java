package com.zhy.juc.c_020;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T08_TestPhaser
 * @Description
 * @Author zhy
 * @Date 2020/8/6 19:30
 * @Version 1.0.0
 **/
public class T09_TestPhaser2 {
    static Random random = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    static void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        phaser.bulkRegister(7);

        for (int i = 0; i < 5; i++) {
            int nameIndex = i;

            new Thread(new Person("person"+nameIndex)).start();

        }

        new Thread(new Person("新娘")).start();
        new Thread(new Person("新郎")).start();
    }

    static class MarriagePhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了！"+registeredParties);
                    return false;

                case 1:
                    System.out.println("所有人都吃完了！"+registeredParties);
                    return false;

                case 2:
                    System.out.println("所有人离开了！"+registeredParties);
                    return true;
                case 3:
                    System.out.println("婚礼结束！新娘新郎抱抱！"+registeredParties);
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable{
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void  arrive(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 到达现场！\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 吃完！\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 离开！\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug(){
            if (name.equals("新娘")||name.equals("新郎")) {
                milliSleep(random.nextInt(1000));
                System.out.printf("%s 洞房 \n",name);
                phaser.arriveAndAwaitAdvance();

            }
        }


        @Override
        public void run() {
            arrive();

            eat();

            leave();

            hug();

        }
    }

}
