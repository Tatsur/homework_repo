package ru.geekbrains.java.homework.j1.homework2a;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        consoleOut();
    }


    private static void task7(int[] array,int step) {
        int arrSize = array.length;
        step %= arrSize;
        if(step>0) step -= arrSize;
        step = Math.abs(step);
        while (step>0){
                for (int i = 0; i < arrSize-1; i++) {

                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
                step--;
        }
        System.out.println(Arrays.toString(array));
    }

    private static boolean task6(int[] array) {
            int tempSum = 0;
            int halfSum = 0;
            for (int i : array) {
                halfSum += i;
            }
            if(halfSum%2>0) {
                halfSum += 1;
            }
            halfSum /= 2;
            for (int i : array) {
                if(tempSum == halfSum)
                    return true;
                else tempSum += i;
            }
        return  false;
        }
    private static void task5() {
        int[] array = {13,10,0,4,3,-6,16,24};
        int max,maxEL,min,minEl;
        max=maxEL=min=minEl=0;
        for (int i = 0; i < array.length ; i++) {

            if(array[i]>=max)
            {
                max = array[i];
                maxEL = i;

            }
            else if(array[i]<=min) {
                min = array[i];
                minEl = i;
            }

        }

        System.out.println("element "+maxEL+" is maximum = " + max);

        System.out.println("element "+minEl+" is minimum = " + min);
    }

    private static void task4(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            array[i][i] = array[i][arrayLength-1-i] = 1;
            for (int k = 0; k < arrayLength; k++) {
                System.out.printf("%d ",array[i][k]);
            }
            System.out.println();
        }
    }

    private static void task3() {
        int[] array = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i : array) {
            if(i<6) i *= 2;
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    private static void task2(int size,int stepValue) {
        int[] intLimArray = new int[size];
        int step = 0;
        for (int i = 0; i < intLimArray.length; i++) {
            intLimArray[i] = step;
            step += stepValue;
        }
        System.out.println(Arrays.toString(intLimArray));
    }

    private static void task1() {
        int[] intArray = {0,1,1,0,1,1,1,0};
        for (int i : intArray) {
            i ^= 1;
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    private static void consoleOut() {
        System.out.println("1__________________");
        task1();
        System.out.println("2__________________");
        task2(8,3);

        System.out.println("3__________________");
        task3();

        System.out.println("4__________________");
        task4(11);

        System.out.println("5__________________");
        task5();

        System.out.println("6__________________");
        System.out.println(task6(new int[]{5, 2, 2, 4, 0, 6,2,5}));

        System.out.println("7__________________");
        task7(new int[]{1,6,-3,4,2,7,9},18);
    }
}
