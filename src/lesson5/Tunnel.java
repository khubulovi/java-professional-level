package lesson5;

import java.util.concurrent.Semaphore;

import static lesson5.Car.CARS_COUNT;


public class Tunnel extends Stage {
    private final Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " metres";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " Get's ready(wait's): " + description);
            System.out.println(c.getName() + " Start: " + description);
            semaphore.acquire();
            Thread.sleep(length / c.getSpeed() * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Listen Please >>> The Tunnel was passed sucsesfuly!!!" + c.getName());
        }
    }
}

