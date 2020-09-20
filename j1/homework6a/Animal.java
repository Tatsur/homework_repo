package ru.geekbrains.java.homework.j1.homework6a;

import java.util.Random;

public class Animal {
    protected static final Random random = new Random();
    private static int animalCounter;
    private int runDistance;
    private int swimDistance;
    private float jumpHeight;

    public Animal() {
        System.out.print("\nAnimal " + ++animalCounter);
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    protected void run(int runDistance) {
        //System.out.println("run distance: " + runDistance + ", max distance: " + this.runDistance);
        System.out.println("run: " + (runDistance <= this.runDistance));
    }

    protected void swim(int swimDistance) {
        //System.out.println("swim distance: " + swimDistance + ", max distance: " + this.swimDistance);
        System.out.println("swim: " + (swimDistance <= this.swimDistance));
    }

    protected void jumpOver(float jumpHeight) {
        //System.out.printf("jump height: %.2f, max jump height: %.2f%n", jumpHeight, this.jumpHeight);
        System.out.println("jump over: " + (jumpHeight <= this.jumpHeight));
    }
}
