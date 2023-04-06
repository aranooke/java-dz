package Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerClass {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread t1 = new Thread(new First(exchanger));
        Thread t2 = new Thread(new Second(exchanger));
        Thread t3 = new Thread(new Third(exchanger));
        Thread t4 = new Thread(new Fourth(exchanger));

        t3.start();
        t2.start();
        t1.start();
        t4.start();
    }
}

class First implements Runnable {
    private final Exchanger<String> exchanger;

    public First(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String input = exchanger.exchange("");
            firstlab.First.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Second implements Runnable {
    private final Exchanger<String> exchanger;

    public Second(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String input = exchanger.exchange("");
            secondlab.Second.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Third implements Runnable {
    private final Exchanger<String> exchanger;

    public Third(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String input = exchanger.exchange("");
            thirdlab.Third.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Fourth implements Runnable {
    private final Exchanger<String> exchanger;

    public Fourth(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("");
            Fourthlab.Fourth.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
