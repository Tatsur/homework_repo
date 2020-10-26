package ru.geekbrains.java.homework.j3.lesson1.Fruits;

import ru.geekbrains.java.homework.j3.lesson1.Fruit;

public class Apple implements Fruit {
    private static final float weight = 1.0f;

    @Override
    public float getWeight() {
        return weight;
    }
}
