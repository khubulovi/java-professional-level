package lesson5;

import static lesson5.Car.countDownLatchRaceStart;

/**
 * Java Core. Professional level. Lesson 5
 * *
 * @author Malkhaz Khubulovi
 * @version dated April 9, 2023
 */


//1. Приведённый код перенести в новый проект.
    // 2. Создать Гонку.



public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("The Race is abaut to start >>> Get ready!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[0] = new Car("Maxo", race, 20 + (int) (Math.random() * 10));
            cars[1] = new Car("Nika", race, 20 + (int) (Math.random() * 10));
            cars[2] = new Car("Alik", race, 20 + (int) (Math.random() * 10));
            cars[3] = new Car("Gio", race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            countDownLatchRaceStart.await();
            System.out.println("Listen Please >>> Race's started!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}







