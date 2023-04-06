package Mutex;




import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexClass {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new First(lock));
        Thread t2 = new Thread(new Second(lock));
        Thread t3 = new Thread(new Third(lock));
        Thread t4 = new Thread(new Fourth(lock));
        t3.start();
        t2.start();
        t1.start();

        t4.start();
    }


}

class First implements  Runnable {

    Lock lock = new ReentrantLock();

    public First(Lock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {

        try {
            lock.lock();
            firstlab.First.main();
            Thread.sleep(1000);
            lock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
class Second implements Runnable {
    Lock lock;

    public Second(Lock lock){
        this.lock = lock;
    }
    @Override
    public void run()
    {
        try {
            lock.lock();
            secondlab.Second.main();
            Thread.sleep(1000);
            lock.unlock();
        }
        catch (Exception e){

        }
    }
}
class Third implements Runnable {
    Lock lock;

    public Third(Lock lock){
        this.lock = lock;
    }
    @Override
    public void run()
    {
        try {
            lock.lock();
            thirdlab.Third.main();
            Thread.sleep(1000);
            lock.unlock();
        }
        catch (Exception e){

        }
    }
}
class Fourth implements Runnable {
    Lock lock;

    public Fourth(Lock lock){
        this.lock = lock;
    }
    @Override
    public void run()
    {
        try {

            Fourthlab.Fourth.main();
            Thread.sleep(1000);

        }
        catch (Exception e){

        }
    }
}

