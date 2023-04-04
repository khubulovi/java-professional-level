package lesson2;

import lesson2.Apps.ClientApp;
import lesson2.Apps.ServerApp;

/**
 * Java Core. Professional level. Lesson 2
 *
 * @author Malkhaz Khubulovi
 * @version dated April 4, 2023
 */
//   Task
//    1. Разобраться с кодом.
//    2. Добавить отключение неавторизованных пользователей по таймауту
//    (120 сек. ждем после подключения клиента. Если он не авторизовался за это время, закрываем соединение).

public class Main {
    public static void main(String[] args) {
        new ClientApp();
        new ServerApp();
    }
}
