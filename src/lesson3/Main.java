package lesson3;

import lesson3.Apps.ClientApp;
import lesson3.Apps.ServerApp;

/**
 * Java Core. Professional level. Lesson 3
 *
 * @author Malkhaz Khubulovi
 * @version dated April 5, 2023
 */
//   Task
//    1. Добавить в сетевой чат запись локальной истории в текстовый файл на клиенте.
//    2. После загрузки клиента показывать ему последние 100 строк чата.

public class Main {
    public static void main(String[] args) {
        new ClientApp();
        new ServerApp();
    }
}
