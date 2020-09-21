package ru.geekbrains.java.homework.j2.lesson1;

public class Barrier implements IObstacles {
    private final int height;
    private static int counter;
    private String name = "Barrier";
    private final EObstacles type = EObstacles.BARRIER;

    public Barrier(int height) {
        this.height = height;
        counter++;
        name += counter;
    }

    @Override
    public float getValue() {
        return height;
    }

    @Override
    public EObstacles getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

}
