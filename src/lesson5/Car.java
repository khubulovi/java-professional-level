package lesson5;


import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    static int CARS_COUNT;
    private final int speed;
    private final String name;
    static CountDownLatch countDownLatchRaceStart = new CountDownLatch(CARS_COUNT);
    static CountDownLatch countDownLatchRaceEnd = new CountDownLatch(CARS_COUNT);
    private static boolean isWinner;
    private Race race;

    public Car(String name, Race race, int speed) {
        this.race=race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " Get ready");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + CARS_COUNT);
            countDownLatchRaceStart.countDown();
            countDownLatchRaceStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (!isWinner) {
            System.out.println("Congragulation The WINNER is: >>> " + this.name);
            isWinner = true;
        }
        countDownLatchRaceEnd.countDown();
        System.out.println("Listen Please >>>" + this.name + " End the Race!!!");
    }
}

