package ru.geekbrains.java.homework.j2.lesson2;

public class MyArraySizeException extends Exception {
    //private final String message;
    public MyArraySizeException(String message){
        super(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArraySizeException(Throwable cause) {
        super(cause);
    }
}
