package ru.geekbrains.java.homework.j2.lesson2;

import java.util.Random;

public class Main extends Exception {
    private static final int ARRAY_SIZE = 4;
    private static final int EXPECTED_ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] array = createArray(ARRAY_SIZE);
        printArray(array);
        try {
            System.out.println("sum of the array: " + task1(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static int task1(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length == EXPECTED_ARRAY_SIZE) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++)
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(String.format("value \"%s\" in cell [%d][%d] can't be parsed to Integer", array[i][j], i, j), e);
                    }
            }
        } else throw new MyArraySizeException("array size must be " + EXPECTED_ARRAY_SIZE);
        return sum;
    }

    private static String[][] createArray(int arraySize) {
        String[][] strings = new String[arraySize][arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                strings[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        strings[random.nextInt(arraySize)][random.nextInt(arraySize)] = "S";
        return strings;
    }

    private static void printArray(String[][] array) {
        for (String[] strings : array) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }
        System.out.println();
    }

}
