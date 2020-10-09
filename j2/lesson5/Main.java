package ru.geekbrains.java.homework.j2.lesson5;

import java.util.Arrays;

public class Main {
    public static final int size = 10_000_000;
    public static final int h = size / 2;

    public static void main(String[] args) {
        float[] array1 = createArray();
        float[] array2 = createArray();
        method1(array1, 0, "Method 1 time in ms:");
        method2(array2, h);
        System.out.println("method1 and method2 arrays are equals? " + Arrays.equals(array1, array2));
    }

    public static float[] createArray() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        return arr;
    }

    public static void method1(float[] arr, int offset, String message) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + offset) / 5f) * Math.cos(0.2f + (i + offset) / 5f) * Math.cos(0.4f + (i + offset) / 2f));
        }
        System.out.println(message + (System.currentTimeMillis() - a));
    }

    public static void method2(float[] arr, int offset) {
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread tr1 = new Thread(() -> {
            method1(a1, 0, "Method 2 first thread time in ms:");
        });
        Thread tr2 = new Thread(() -> {
            method1(a2, h, "Method 2 second thread time in ms:");
        });
        tr1.start();
        tr2.start();
        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Method 2 time in ms:" + (System.currentTimeMillis() - a));
    }
}
