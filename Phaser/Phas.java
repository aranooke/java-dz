package Phaser;

import java.io.IOException;
import java.util.concurrent.Phaser;

public class Phas {
    public static void main(String[] args) {
        java.util.concurrent.Phaser phaser = new java.util.concurrent.Phaser(4);
        Thread t1 = new Thread(new First(phaser));
        Thread t2 = new Thread(new Second(phaser));
        Thread t3 = new Thread(new Third(phaser));
        Thread t4 = new Thread(new Fourth(phaser));
        t3.start();
        t2.start();
        t1.start();
        t4.start();
    }
}

class First implements Runnable {
    java.util.concurrent.Phaser phaser;

    public First(java.util.concurrent.Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        synchronized (System.in) {
            try {
                System.out.println("First thread - Enter any character to start:");
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndAwaitAdvance();
        try {
            firstlab.First.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Second implements Runnable {
    java.util.concurrent.Phaser phaser;

    public Second(java.util.concurrent.Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        synchronized (System.in) {
            try {
                System.out.println("Second thread - Enter any character to start:");
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndAwaitAdvance();
        secondlab.Second.main();
    }
}

class Third implements Runnable {
    java.util.concurrent.Phaser phaser;

    public Third(java.util.concurrent.Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        synchronized (System.in) {
            try {
                System.out.println("Third thread - Enter any character to start:");
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndAwaitAdvance();
        thirdlab.Third.main();
    }
}

class Fourth implements Runnable {
    java.util.concurrent.Phaser phaser;

    public Fourth(java.util.concurrent.Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        synchronized (System.in) {
            try {
                System.out.println("Fourth thread - Enter any character to start:");
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        phaser.arriveAndAwaitAdvance();

    }
}