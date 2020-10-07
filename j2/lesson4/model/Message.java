package ru.geekbrains.java.homework.j2.lesson4.model;

import java.util.Date;

public class Message {
    private final String text;
    private User user;
    private final Date date;
    private static final String DEFAULT_NAME = "You";

    public Message(String text, Date date, User user)  {
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user.getUserName();
    }

    public Date getDate() {
        return date;
    }
}
