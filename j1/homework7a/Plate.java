package ru.geekbrains.java.homework.j1.homework7a;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite;
    }

    public void addFood(int foodAmount) {
        this.food += foodAmount;
    }

    public boolean isEmptyPlate() {
        return food < 1;
    }
}
