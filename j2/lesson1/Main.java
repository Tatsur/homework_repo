package ru.geekbrains.java.homework.j2.lesson1;

public class Main {
    public static void main(String[] args) {
        IObstacles[] obstacles = new IObstacles[]{
                new Track(200),
                new Track(300),
                new Barrier(1),
                new Track(3000),
                new Barrier(2),
                new Track(10000),
        };
        IParticipants[] participants = new IParticipants[]{
                new Human(2, 10000),
                new Cat(1.8f, 2000),
                new Robot()
        };
        for (IParticipants participant : participants) {
            for (IObstacles obstacle : obstacles) {
                if (!participant.overcomeObstacle(obstacle.getValue(), obstacle.getName(), obstacle.getType())) break;
            }
        }
    }
}
