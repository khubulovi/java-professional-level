package lesson6;

import java.util.Arrays;


/**
 * Java Core. Professional level. Lesson 6
 * *
 * @author Malkhaz Khubulovi
 * @version dated April 11, 2023
 */


//    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
//    Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
//    Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
//
//    2. Написать метод, который проверяет состав массива из чисел 1 и 4.
//    Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).

public class Main {
    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();
        System.out.println(Arrays.toString(arrayHandler.getValueAfterLastFour(new int[]{1, 2, 3, 4, 5, 5, 2})));
        System.out.println(arrayHandler.findFourOrOneNumberInArray(new int[]{1, 1, 1, 4, 4, 4}));
    }
}
