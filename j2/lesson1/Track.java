package ru.geekbrains.java.homework.j2.lesson1;

public class Track implements IObstacles {
    private final int distance;
    private static int counter;
    private String name = "Track";
    private final EObstacles type = EObstacles.TRACK;

    public Track(int distance) {
        this.distance = distance;
        counter++;
        name += counter;
    }

    @Override
    public float getValue() {
        return distance;
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
