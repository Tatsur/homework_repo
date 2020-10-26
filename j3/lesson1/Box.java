package ru.geekbrains.java.homework.j3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public float getWeight() {
        float sum = 0;
        for (T item : fruits) {
            sum += item.getWeight();
        }
        return sum;
    }
    public <E extends Fruit> boolean compare(Box<E> anotherBox){
        return anotherBox.getWeight() == this.getWeight();
    }
    public void addFruit(T fruit){
        fruits.add(fruit);
    }
    public void moveToOtherBox(Box<T> emptyBox){
        for (T fruit : fruits) {
            emptyBox.addFruit(fruit);
        }
        fruits.clear();
    }
}
