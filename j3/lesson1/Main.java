package ru.geekbrains.java.homework.j3.lesson1;

import ru.geekbrains.java.homework.j3.lesson1.Fruits.Apple;
import ru.geekbrains.java.homework.j3.lesson1.Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        method1AndMethod2Check();
        task3();
    }

    private static void task3() {
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 6; i++) {
            appleBox.addFruit(new Apple());
        }
        System.out.println("Apple box weight: " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 4; i++) {
            orangeBox.addFruit(new Orange());
        }
        System.out.println("Orange box weight: " + orangeBox.getWeight());
        System.out.println("Apple box and orange box have equals weight: " + orangeBox.compare(appleBox));
        Box<Orange> newOrangeBox = new Box<>();
        orangeBox.moveToOtherBox(newOrangeBox);
        System.out.println("New orange box weight: "+ newOrangeBox.getWeight());
        System.out.println("Orange box weight: " + orangeBox.getWeight());
        newOrangeBox.addFruit(new Orange());
        System.out.println("One orange added to newOrangeBox");
        System.out.println("New orange box weight: "+ newOrangeBox.getWeight());
    }

    private static void method1AndMethod2Check() {
        Integer[] array = new Integer[]{5, 2, 13,16,1};
        printArray(array);
        printArray(swapArrayElements(array,1,4 ));
        printArray(swapArrayElements(array,3,0 ));
        System.out.println(convertToArrayList(array));
    }
    private static <T> T[] swapArrayElements(T[] array, int index1, int index2){
        try {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index value out of array length");
            e.printStackTrace();
        }
        return array;
    }
    private static <T> void printArray(T[] array){
        for (T t : array) {
            System.out.printf("%s ",t.toString());
        }
        System.out.println();
    }
    private static <T> ArrayList<T> convertToArrayList(T[] array){
        if(array != null) {
            return new ArrayList<>(Arrays.asList(array));
        }
        return new ArrayList<>();
    }
}
