package ru.geekbrains.java.homework.j1.homework3a;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
    public static String targetWord = words[random.nextInt(words.length)];
    public static int targetWordLength = targetWord.length();
    public static char maskChar = '#';
    public static String maskNull = "";

    public static void main(String[] args) {

        StringBuilder mask = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            maskNull += maskChar;
        }
        mask.replace(0,mask.length(),maskNull);
        System.out.println(maskNull);
        System.out.println("Guess the word: ");
        guessTheWord(mask);
    }

    private static void guessTheWord(StringBuilder mask) {
        String guessWord = scanner.next();
        guessWord = guessWord.toLowerCase();
        if (targetWord.equals(guessWord)) {
            System.out.println("Congratulation! You guessed the word!");
        } else {
            int limits = Math.min(targetWordLength, guessWord.length());
            for (int i = 0; i < limits; i++) {
                if (targetWord.charAt(i) == guessWord.charAt(i)) {
                    mask.deleteCharAt(i);
                    mask.insert(i, guessWord.charAt(i));
                }
            }
            System.out.println(mask);
            System.out.println("Oops! You are mistaken :(");
            System.out.println("Guess the word again: ");
            mask.replace(0,mask.length(),maskNull);
            guessTheWord(mask);
        }
    }
}
