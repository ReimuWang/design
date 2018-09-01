package design17_2;

import java.util.Random;

public class Model implements Runnable {

    int number;

    long sleepTime;

    private int numberRange;

    public Model(long sleepTime, int numberRange) {
        this.sleepTime = sleepTime;
        this.numberRange = numberRange;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            this.number = random.nextInt(this.numberRange);
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}