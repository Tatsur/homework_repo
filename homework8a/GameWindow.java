package ru.geekbrains.java_one.homework.homework8a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 400;
    private static final int WIN_HEIGHT = 400;

    public static Map map;
    private SettingsWindow settings;

    GameWindow() {
        windowInit();

        map = new Map();
        settings = new SettingsWindow(this);

        addBottomPanel();
        add(map);

        setVisible(true);
    }

    private void windowInit() {
        setLocationRelativeTo(null);
        setLocation(getX()-WIN_WIDTH/2,getY()-WIN_HEIGHT/2);
        setResizable(false);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addBottomPanel() {
        JButton buttonStart = new JButton("New game");
        JButton buttonExit = new JButton("Exit");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottomButtons = new JPanel();
        panelBottomButtons.setLayout(new GridLayout(1, 2));
        panelBottomButtons.add(buttonStart);
        panelBottomButtons.add(buttonExit);

        add(panelBottomButtons, BorderLayout.SOUTH);
    }

    void startNewGame(int mode, int fieldSize, int winLength) {
        map.startNewGame(mode, fieldSize, winLength);
    }


}
