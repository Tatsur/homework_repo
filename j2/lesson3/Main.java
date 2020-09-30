package ru.geekbrains.java.homework.j2.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Vasilkov", 8_315_435_45_21L);
        phonebook.add("Vasilkov", 8_315_500_60_80L);
        phonebook.add("Ivanov", 8_313_400_20_15L);
        phonebook.add("Durov", 8_315_313_13_25L);
        phonebook.add("Durov", 8_319_353_25_25L);
        phonebook.add("Durov", 8_320_363_14_14L);
        phonebook.get("Vasilkov");
        phonebook.get("Ivanov");
        phonebook.get("Durov");
        phonebook.get("Stalin");
    }

    private static void task1() {
        ArrayList<String> baseArray = new ArrayList<>(Arrays.asList(
                "pen", "pineapple", "apple", "pen", "orange",
                "cabbage", "potato", "pumpkin", "carrot", "plum",
                "apple", "pen"));
        System.out.println(baseArray);
        Map<String, Integer> printArray = new LinkedHashMap<>();
        for (String value : baseArray) {
            if (!printArray.containsKey(value)) {
                printArray.put(value, 1);
            } else {
                printArray.put(value, printArray.get(value) + 1);
            }
        }
        System.out.println(printArray);
    }
}
