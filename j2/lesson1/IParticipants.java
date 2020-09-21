package ru.geekbrains.java.homework.j2.lesson1;

public interface IParticipants {
    String SUCCESSFUL_MESSAGE = " overcame the ";
    String UNSUCCESSFUL_MESSAGE = " didn't overcome the ";

    boolean run(float distance, String obstacleName);

    boolean jump(float height, String obstacleName);

    boolean overcomeObstacle(float value, String obstacleName, EObstacles obstacleType);
}
