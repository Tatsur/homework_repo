package ru.geekbrains.java_one.homework.homework6a;

public class Main {
    public static void main(String[] args) {
        Animal dog1 = new Dog();
        dog1.run(500);
        dog1.swim(11);
        dog1.jumpOver(0.6f);

        Animal cat1 = new Cat();
        cat1.run(210);
        cat1.swim(5);
        cat1.jumpOver(2.5f);

        Dog an = new Dog();
        an.swim(5);
    }
}
