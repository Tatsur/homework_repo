package ru.geekbrains.java.homework.j2.lesson4.model;

public class User {
    private String userName;
    public final static String DEFAULT_USER_NAME = "USER";

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    };
}
