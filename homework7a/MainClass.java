package ru.geekbrains.java_one.homework.homework7a;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Vasya", 10),
                new Cat("Felix", 16),
                new Cat("Sam", 9),
                new Cat("Tom", 8)
        };
        Plate plate = new Plate(5);
        plate.addFood(25);
        plate.info();
        feedCats(cats, plate);
        addFoodForHungryCats(cats, plate);
        feedCats(cats, plate);
        System.out.println(plate.isEmptyPlate());
    }

    private static void addFoodForHungryCats(Cat[] cats, Plate plate) {
        int addFoodValue = 0;
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                addFoodValue += cat.getAppetite();
            }
        }
        plate.addFood(addFoodValue - plate.getFood());
        plate.info();
    }

    private static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.getSatietyInfo();
        }
        plate.info();
    }

}
