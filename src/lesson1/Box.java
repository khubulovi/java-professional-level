package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    private ArrayList<T> list;

    public Box(ArrayList<T> list) {
        this.list = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T...fruit) {
        this.list = new ArrayList<>(Arrays.asList(fruit));
    }
    public float getWeight() {
        float weight = 0.0f;

        for (T o : list
        ) {
            weight += o.getWeight();
        }return weight;
    }

    public void add(T fruit){
        list.add(fruit);
    }

    public boolean compare(Box<?> o){

        return Math.abs(this.getWeight()-o.getWeight()) < 0.01;
    }
    public void add(Box<T> fruit){
        fruit.list.addAll(list);
        list.clear();
    }
}
