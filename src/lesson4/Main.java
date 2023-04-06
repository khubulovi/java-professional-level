package lesson4;


/**
 * Java Core. Professional level. Lesson 4
 *
 * @author Malkhaz Khubulovi
 * @version dated April 6, 2023
 */


//    1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
//    Используйте wait/notify/notifyAll.

public class Main {
    public static void main(String[] args) {
        new Thread(new WaitAndNotify('B','C')).start();
        new Thread(new WaitAndNotify('C','A')).start();
        new Thread(new WaitAndNotify('A','B')).start();
    }
}
