package Sync;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Sync {
    private static Lock lock = new ReentrantLock();
    private static Condition firstCondition = lock.newCondition();
    private static Condition secondCondition = lock.newCondition();
    private static Condition thirdCondition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new First());
        Thread t2 = new Thread(new Second());
        Thread t3 = new Thread(new Third());
        Thread t4 = new Thread(new Fourth());

        t3.start();
        t2.start();
        t1.start();
        t4.start();

        Thread.sleep(1000);

        lock.lock();
        try {
            thirdCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    static class First implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                firstCondition.await();
                firstlab.First.main();
                secondCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Second implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                secondCondition.await();
                secondlab.Second.main();
                firstCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Third implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                thirdCondition.await();
                thirdlab.Third.main();
                secondCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Fourth implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                Fourthlab.Fourth.main();
            } finally {
                lock.unlock();
            }
        }
    }
}
