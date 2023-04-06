package com.company;



import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // Семафоры
        Semaphore semaphore = new Semaphore(1); // ограничиваем доступ потоку

        Thread t1 = new Thread(new First(semaphore));
        Thread t2 = new Thread(new Second(semaphore));
        Thread t3 = new Thread(new Third(semaphore));
        Thread t4 = new Thread(new Fourth(semaphore));

        t3.start();
        t1.start();
        t4.start();
        t2.start();




        ;
    }
}
class First implements  Runnable {
    Semaphore semaphore;
    Lock lock = new ReentrantLock();

    public First(Lock lock) {
        this.lock = lock;
    }

    public First(Semaphore semaphore) {
        this.semaphore = semaphore;
    }



    @Override
    public void run() {

        try {
            semaphore.acquire();
            firstlab.First.main();
            Thread.sleep(1000);
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
class Second implements  Runnable {
    Semaphore semaphore;

    public Second(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            secondlab.Second.main();
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class Third implements  Runnable {
    Semaphore semaphore;

    public Third(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            thirdlab.Third.main();
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class Fourth implements  Runnable {
    Semaphore semaphore;

    public Fourth(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

            Fourthlab.Fourth.main();



    }
}


