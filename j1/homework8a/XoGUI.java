package ru.geekbrains.java.homework.j1.homework8a;

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
