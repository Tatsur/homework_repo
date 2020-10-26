package ru.geekbrains.java.homework.j3.lesson1.Fruits;

import ru.geekbrains.java.homework.j3.lesson1.Fruit;

public class Orange implements Fruit {
    private static final float weight = 1.5f;

    @Override
    public float getWeight() {
        return weight;
    }
}
