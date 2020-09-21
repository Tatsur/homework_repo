package ru.geekbrains.java.homework.j2.lesson1;

public class Robot implements IParticipants {
    public static final float JUMP_HEIGHT = 3;
    public static final float MAX_DISTANCE = 40000;
    private int sumDistance;
    private static final String NAME = "Robot";

    public boolean overcomeObstacle(float distance, String obstacleName, EObstacles obstacleType) {
        switch (obstacleType) {
            case TRACK:
                return run(distance, obstacleName);
            case BARRIER:
                return jump(distance, obstacleName);
            default:
                return false;
        }
    }

    @Override
    public boolean run(float distance, String obstacleName) {
        sumDistance += distance;
        if (sumDistance > MAX_DISTANCE) {
            System.out.println(NAME + UNSUCCESSFUL_MESSAGE + obstacleName);
            return false;
        }
        System.out.println(NAME + SUCCESSFUL_MESSAGE + obstacleName);
        return true;
    }

    @Override
    public boolean jump(float height, String obstacleName) {
        if (height > JUMP_HEIGHT) {
            System.out.println(NAME + UNSUCCESSFUL_MESSAGE + obstacleName);
            return false;
        }
        System.out.println(NAME + SUCCESSFUL_MESSAGE + obstacleName);
        return true;
    }
}
