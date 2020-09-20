package ru.geekbrains.java.homework.j1.homework6a;

public class Dog extends Animal {
    private static final int BASE_RUN_BOUND = 400;
    private static final int BASE_SWIM_BOUND = 8;
    private static final float BASE_JUMP_HEIGHT_BOUND = 0.3f;
    private static final int RUN_BOUND_RANGE = 200;
    private static final int SWIM_BOUND_RANGE = 5;
    private static final float JUMP_HEIGHT_MULTIPLIER_RANGE = 0.5f;

    public Dog() {
        setRunDistance(BASE_RUN_BOUND + random.nextInt(RUN_BOUND_RANGE));
        setSwimDistance(BASE_SWIM_BOUND + random.nextInt(SWIM_BOUND_RANGE));
        setJumpHeight(BASE_JUMP_HEIGHT_BOUND + random.nextFloat() * JUMP_HEIGHT_MULTIPLIER_RANGE);
        System.out.println(": dog");
        System.out.println("_____________");
    }

}
