package ru.geekbrains.java_one.homework.homework6a;

public class Cat extends Animal {
    private static final int BASE_RUN_BOUND = 150;
    private static final float BASE_JUMP_HEIGHT_BOUND = 1.5f;
    private static final int RUN_BOUND_RANGE = 100;

    public Cat() {
        setRunDistance(BASE_RUN_BOUND + random.nextInt(RUN_BOUND_RANGE));
        setJumpHeight(BASE_JUMP_HEIGHT_BOUND + random.nextFloat());
        System.out.println(": cat");
        System.out.println("_____________");
    }

    @Override
    protected void swim(int swimDistance) {
        System.out.println("Cat doesn't want to swim");
    }

}
