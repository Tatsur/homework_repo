package ru.geekbrains.java_one.homework.homework7a;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (!satiety && plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    public void getSatietyInfo() {
        System.out.println(name + " is fed:" + satiety);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }
}
