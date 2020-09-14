package ru.geekbrains.java_one.homework.homework8a;

import java.awt.*;

public class XoGUI {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
}
