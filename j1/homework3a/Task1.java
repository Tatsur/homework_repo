package ru.geekbrains.java.homework.j1.homework3a;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        guessTheNumber(scanner, random);
        scanner.close();
    }

    private static void guessTheNumber(Scanner scanner, Random random) {
        int value;
        int triesCount = 3;
        int randomValue = random.nextInt(10);
        System.out.println("Guess the number from 0 to 10: ");

        while (triesCount > 0) {
            triesCount--;

            if (scanner.hasNextInt())
                value = scanner.nextInt();
            else {
                System.out.println("Incorrect input!\nPlease enter an integer value: ");
                scanner.nextLine();
                continue;
            }

            if (value == randomValue) {
                System.out.println("Congratulations! You guessed the number!");
                if (tryAgain(scanner, random))
                    break;
            } else if (value < randomValue) {
                System.out.println("The number is greater than you guessed");
                nextTryPrintOut(triesCount);
            } else {
                System.out.println("The number is less than you guessed");
                nextTryPrintOut(triesCount);
            }

            if (triesCount <= 0) {
                System.out.println("You've run out of attempts! You lost!");
                if (tryAgain(scanner, random))
                    break;
            }
        }
    }

    private static void nextTryPrintOut(int triesCount) {
        System.out.println("Attempts left: " + triesCount);
        if (triesCount > 0) {
            System.out.println("Guess the number: ");
        }
    }

    private static boolean tryAgain(Scanner scanner, Random random) {
        int value;
        System.out.println("Do you want to play again? 1 - yes / 0 - no");
        value = scanner.nextInt();
        if (value == 1) {
            guessTheNumber(scanner, random);
        } else return true;
        return false;
    }
}
