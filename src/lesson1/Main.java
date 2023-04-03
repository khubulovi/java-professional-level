package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java Core. Professional level. Lesson 1
 *
 * @author Malkhaz Khubulovi
 * @version dated April 3, 2023
 */


//     1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//     2. Написать метод, который преобразует массив в ArrayList;
//     3. Большая задача:
//   Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
//   Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//   Для хранения фруктов внутри коробки можно использовать ArrayList;
//   Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
//   Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//   Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//   Не забываем про метод добавления фрукта в коробку.

public class Main {
    public static void main(String[] args) {
        String [] arr={"Anano","Baratashvili","Gilocav","Dabadebisdges"};
        renewArrayList(arr);
        System.out.println(Arrays.toString(arr));
        swapElemArray(arr,0,1);
        System.out.println(Arrays.toString(arr));




        //Task3
        Box <Fruit> fruitBox=new Box<Fruit>();
        fruitBox.add(new Orange());
        fruitBox.add(new Orange());
        fruitBox.add(new Orange());
        fruitBox.add(new Apple());
        Box<Fruit>fruitBox1=new Box<>();
        fruitBox1.add(new Apple());
        fruitBox1.add(new Orange());
        fruitBox1.add(new Orange());
        fruitBox1.add(new Orange());

        fruitBox1.add(fruitBox);
        System.out.println( fruitBox1.compare(fruitBox));
        System.out.println(fruitBox.getWeight());}


    //Task1
    public static <T> void swapElemArray(T[] arr,int firstIndex,int secondIndex){
        T var=arr [firstIndex];
        arr [firstIndex]=arr[secondIndex];
        arr[secondIndex]=  var;
    }

    //Task2

    public static <T> ArrayList<T> renewArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
